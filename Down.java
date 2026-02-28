package User;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xhtmlrenderer.pdf.ITextRenderer;

@WebServlet("/Down")
public class Down extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        String user=(String) application.getAttribute("Name");
        
        
        String contextPath = request.getContextPath();
        String imageUrl = contextPath + "/WebContent/logoChecck.jpg";
        ServletContext session = request.getServletContext();
        String time = (String)session.getAttribute("time");
        
       
        String msg = (String) application.getAttribute("A");
        // --- 1. Define the Simple HTML Content ---
        String simpleHtmlContent = 
           "<html>" +
           "<head>" +
           "<title>Knowledge Check Demonstration Certificate</title>" +
           "<style>" +
           "  @page {" + 
           "    size: A4 portrait;" + 
           "    margin: 0;" + 
           "  }" + 
           "  body {" + 
           "    background-image: url('U.jpg');" +
           "    background-repeat: no-repeat;" +
           "    background-size: 100% 100%;" +
           "    background-position: center;" +
           "    font-family: 'Times New Roman', serif;" +
           "    margin: 0;" +
           "    padding: 0;" +
           "    width: 210mm;" +
           "    height: 297mm;" +
           "  }" + 
           "  .U {" + 
           "    width: 210mm;" +
           "    height: 297mm;" +
           "    text-align: center;" +
           "    border: 10px solid gold;" +
           "    box-sizing: border-box;" +
           "    padding: 50px 40px 40px 40px;" +
           "    display: flex;" +
           "    flex-direction: column;" +
           "    justify-content: space-between;" +
           "  }" +
           "  .content-top {" +
           "    flex: 0 0 auto;" +
           "  }" +
           "  .content-middle {" +
           "    flex: 1;" +
           "    display: flex;" +
           "    flex-direction: column;" +
           "    justify-content: center;" +
           "  }" +
           "  .content-bottom {" +
           "    flex: 0 0 auto;" +
           "  }" +
           "  .logo {" + 
           "    height: 137px;" + 
           "    width: 103px;" + 
           "    display: block;" + 
           "    margin-top:180px;" +
           "margin-left:294px;"+
           "  }" +
           "  .demo-title {" + 
           "    color: HotPink;" + 
           "    font-size: 34px;" + 
           "    font-weight: bold;" + 
           "text-decoratioN:uNderliNe;"+
             "text-decoration-color:HotPiNk;"+
           "    margin: 20px 0;" +
           "  }" +
           "  .cert-title {" + 
           "    color: Blue;" + 
           "    font-size: 30px;" + 
           "    font-weight: bold;" + 
           "    margin-left: 14px;" +
           "  }" +
           "  .presented {" + 
           "    font-size: 16px;" + 
           "    margin: 15px 0;" +
           "  }" +
           "  .user-name {" + 
           "    color: HotPink;" + 
           "    font-size: 40px;" + 
           "    font-weight: bold;" + 
           "    margin: 25px 0;" +
           "  }" +
           "  .achievement {" + 
           "    font-weight: bold;" + 
           "    font-size: 15px;" + 
           "    margin: 10px 0;" + 
           "    padding: 0 60px;" +
           "  }" +
           "  .footer-section {" + 
           "    margin-top: 40px;" +
           "    padding: 0 20px;" +
           "  }" +
           "  .date {" + 
           "    display: inline-block;" + 
           "    font-weight: bold;" + 
           "    font-size: 14px;" + 
           "    width: 45%;" +
           "    padding-left:400px;" +
           "  }" +
           "  .signature {" + 
           "    display: inline-block;" + 
           "    font-weight: bold;" + 
           "    font-size: 14px;" + 
           "    width: 45%;" +
           "    padding-right:400px;" +
           "  }" +
           "</style>" +
           "</head>" +
           "<body>" +
           "<div class='U'>" +
           "  <div class='content-top'>" +
        
           "    <img src='logoCheck.jpg' class='logo' />" +
           "  </div>" +
           "  <div class='content-middle'>" +
           "    <p class='demo-title'>Knowledge Check Demonstration</p>" +
           "    <p class='cert-title'>CERTIFICATE OF ACHIEVEMENT</p>" +
           "    <p class='presented'>Proudly Presented To</p>" +
           "    <h1 class='user-name'>" + user + "</h1>" +
           "    <p class='achievement'>For successfully completing the Assessment in</p>"+
           "<br></br><p>"+msg+"</p>" +
           "    <p class='achievement'>with an outstanding score.</p>" +
           "  </div>" +
           "  <div class='content-bottom'>" +
           "    <div class='footer-section'>" +
           "      <span class='date'>Date: " + time + "</span>" +
           "      <span class='signature'>Signature</span>" +
           "    </div>" +
           "  </div>" +
           "</div>" +
           "</body>" +
           "</html>";

        // --- 2. Set Response Headers for Download ---
        String pdfFileName = user + new Date().getTime() + ".pdf";
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + pdfFileName + "\"");

        // --- 3. Use Flying Saucer to Render PDF ---
        try (OutputStream os = response.getOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            String baseUrl = "http://localhost:8585/Knowledge_Check/"; 
            
            renderer.setDocumentFromString(simpleHtmlContent, baseUrl);
            renderer.layout();
            renderer.createPDF(os);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                "PDF Generation Failed: " + e.getMessage());
        }
    }
}