package User;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

@WebServlet("/Download")
public class Download extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {

		    // 1. *CRITICAL STEP: CAPTURE RENDERED HTML*
		    //    The output of Certificate.jsp must be captured into a String.
		    String htmlContent = "<h1>Hello</h1>";
		    String studentName = (String) request.getSession().getAttribute("Name"); // Get student name for filename
		    
		    try (StringWriter stringWriter = new StringWriter();
		         PrintWriter printWriter = new PrintWriter(stringWriter)) {
		        
		        // Use a Response Wrapper to redirect the JSP's output
		        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
		            @Override
		            public PrintWriter getWriter() {
		                return printWriter;
		            }
		        };
		        
		        // Execute the JSP and capture its full, dynamic content
		        request.getRequestDispatcher("/Certificate.jsp").forward(request, responseWrapper);
		        printWriter.flush();
		        htmlContent = stringWriter.toString(); 

		    } catch (Exception e) {
		        // Handle JSP rendering error
		        e.printStackTrace();
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "JSP content capture failed.");
		        return; 
		    }

		    // --- EXECUTE PDF GENERATION ---
		    
		    // 2. Set Response Headers for Download (Correct, but ensure studentName is used)
		  
		    response.setHeader("Content-Disposition","attachment; filename=\"Certificate_" + studentName + ".pdf\""); 

		    // 3. Use Flying Saucer to Render PDF
		    try (OutputStream os = response.getOutputStream()) {
		        ITextRenderer renderer = new ITextRenderer();

		        // 3a. Pass the correctly captured HTML content here
		        renderer.setDocumentFromString(htmlContent); 

		        // 3b. Resolve CSS links, image paths, etc.
		        String contextPath=request.getContextPath();
		        String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
		        //String baseUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/")) + "/";
		        renderer.setDocument(baseUrl); 

		        renderer.layout();
		        renderer.createPDF(os);
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "PDF Generation Failed");
		    }
	}
}
