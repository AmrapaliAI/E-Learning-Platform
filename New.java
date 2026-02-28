package User;
import Conec.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.*;
import java.io.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/New")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1MB
	    maxFileSize = 5 * 1024 * 1024,   // 5MB
	    maxRequestSize = 10 * 1024 * 1024 // 10MB
	)
public class New extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter u = response.getWriter();
    
        // Get all parameters
        String name = request.getParameter("Name");
        String P = request.getParameter("P");
        String email = request.getParameter("email");
        String U = request.getParameter("Number");
        String ClassName = request.getParameter("C");
        String password = request.getParameter("Password");
        String Addre = request.getParameter("A");
        Part photoPart = request.getPart("photo");
        
        
        String fileName = Paths.get(photoPart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        
        String photoPath = uploadPath + File.separator + fileName;
        photoPart.write(photoPath); 
        
        // VALIDATION STEP 1: Check if ANY required field is empty
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("E", "Required Name field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (email == null || email.trim().isEmpty()) {
            request.setAttribute("Error", "Required email field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (U == null || U.trim().isEmpty()) {
            request.setAttribute("M", "Required Mobile Number field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        // VALIDATION: Check if mobile number is valid (numeric and 10 digits)
        if (!U.matches("\\d{10}")) {
            request.setAttribute("M", "Mobile number must be exactly 10 digits");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (ClassName == null || ClassName.trim().isEmpty()) {
            request.setAttribute("Class", "Required ClassName field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (password == null || password.trim().isEmpty()) {
            request.setAttribute("Password", "Required Password field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (P == null || P.trim().isEmpty()) {
            request.setAttribute("P", "Please confirm your password");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        if (Addre == null || Addre.trim().isEmpty()) {
            request.setAttribute("Address", "Address field cannot be empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        // VALIDATION STEP 2: Password strength check (ONLY ONCE)
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";
        if (!password.matches(passwordRegex)) {
            request.setAttribute("regu", 
                "Password must be at least 8 characters and contain uppercase, lowercase, and special character");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        // VALIDATION STEP 3: Password match check
        if (!password.equals(P)) {
            request.setAttribute("P", "Passwords must match");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        // NOW store in session AFTER validation passes
        HttpSession session = request.getSession();
        session.setAttribute("name2", name);
        session.setAttribute("email", email);
        session.setAttribute("number", U);
        session.setAttribute("C", ClassName);
        session.setAttribute("Pa", password);
        session.setAttribute("P1", P);
        session.setAttribute("Addr", Addre);
        
        
        // Parse mobile number AFTER validation
        long N = 0;
        try {
            N = Long.parseLong(U);
        } catch (NumberFormatException e) {
            request.setAttribute("M", "Invalid mobile number format");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            u.close();
            return;
        }
        
        try {
            Connection C = Serv.get();
            
            // Check if email already exists
            PreparedStatement M = C.prepareStatement("SELECT * FROM UserData WHERE email = ?");
            M.setString(1, email);
            ResultSet R = M.executeQuery();
            
            if (R.next()) {
                R.close();
                M.close();
                C.close();
                request.setAttribute("Email", "Email Already Exists in System.");
                request.getRequestDispatcher("index1.jsp").include(request, response);
                u.close();
                return;
            }
            R.close();
            M.close();
            
            // Insert into database
            CallableStatement login = C.prepareCall("{call Data(?,?)}");
            login.setString(1, name);
            login.setString(2, email);
            login.execute();
            login.close();
            
            CallableStatement Y = C.prepareCall("{call UserInfo(?,?,?,?,?,?,?)}");
            Y.setString(1, name);
            Y.setString(2, password);
            Y.setString(3, email);
            Y.setString(4, Addre);
            Y.setString(5, ClassName);
            Y.setLong(6, N);
            Y.setString(7, "uploads/" + fileName);
            Y.execute();
            Y.close();
            
            C.close();
            
            // Clear session after successful registration
            session.invalidate();
            
            // SUCCESS MESSAGE - DON'T include index1.jsp, just redirect
            u.print("<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>");
            
            u.print("<div id='successOverlay' style='position: fixed; top: 0; left: 0; width: 100%; height: 100%; "
                + "background: rgba(0,0,0,0.5); z-index: 9998;' "
                + "onclick=\"window.location.href='index1.jsp';\"></div>");

            u.print("<div id='successModal' style='position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); "
                + "background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); "
                + "padding: 40px 60px; border-radius: 20px; box-shadow: 0 20px 60px rgba(0,0,0,0.3); "
                + "text-align: center; z-index: 9999; animation: slideIn 0.5s ease-out;'>");

            u.print("<style>"
                + "@keyframes slideIn { from { opacity: 0; transform: translate(-50%, -60%); } "
                + "to { opacity: 1; transform: translate(-50%, -50%); } }"
                + "@keyframes checkmark { 0% { transform: scale(0); } 50% { transform: scale(1.2); } "
                + "100% { transform: scale(1); } }"
                + "</style>");

            u.print("<div style='background: white; width: 80px; height: 80px; border-radius: 50%; "
                + "margin: 0 auto 20px; display: flex; align-items: center; justify-content: center; "
                + "animation: checkmark 0.6s ease-out;'>");
            u.print("<svg width='50' height='50' viewBox='0 0 50 50'>"
                + "<path d='M10 25 L20 35 L40 15' stroke='#667eea' stroke-width='4' "
                + "fill='none' stroke-linecap='round' stroke-linejoin='round'/></svg>");
            u.print("</div>");

            u.print("<h2 style='color: white; font-family: Arial, sans-serif; margin: 0 0 15px 0; "
                + "font-size: 32px; font-weight: bold;'>Registration Successful!</h2>");

            u.print("<p style='color: rgba(255,255,255,0.95); font-family: Arial, sans-serif; "
                + "font-size: 18px; margin: 0 0 25px 0; line-height: 1.6;'>"
                + "Welcome aboard, <strong>" + name + "</strong>!<br>"
                + "Your account has been created successfully.</p>");

            u.print("<button onclick=\"window.location.href='index1.jsp';\" "
                + "style='background: white; color: #667eea; border: none; padding: 15px 40px; "
                + "border-radius: 30px; font-size: 16px; font-weight: bold; cursor: pointer; "
                + "transition: all 0.3s ease; box-shadow: 0 5px 15px rgba(0,0,0,0.2);' "
                + "onmouseover='this.style.transform=\"scale(1.05)\"; this.style.boxShadow=\"0 8px 20px rgba(0,0,0,0.3)\"' "
                + "onmouseout='this.style.transform=\"scale(1)\"; this.style.boxShadow=\"0 5px 15px rgba(0,0,0,0.2)\"'>"
                + "Get Started       LOGIN&#x2728;</button>");

            u.print("</div>");
            
            // Auto-redirect after 3 seconds
            u.print("<script>setTimeout(function(){ window.location.href='index1.jsp'; }, 3000);</script>");
            
            u.print("</body></html>");
            
        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("U", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("index1.jsp").include(request, response);
        } finally {
            u.close();
        }
    }
}