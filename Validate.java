package User;

import Conec.Serv;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validate")
public class Validate extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("Name");
        String password = request.getParameter("Password");
        
        // ================================
        // PASSWORD VALIDATION ONLY
        // ================================
        String passwordRegex = 
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";

        if (password == null || !password.matches(passwordRegex)) {
            request.setAttribute(
                "regu",
                "Password must be at least 8 characters and contain uppercase, lowercase, and special character"
            );
            request.getRequestDispatcher("index1.jsp").include(request, response);
            out.close();
            return;
        }

        HttpSession session = request.getSession();
        ServletContext application = getServletContext();
        application.setAttribute("U", name);
        session.setAttribute("User", name);

        // Basic validation
        if ((name == null || name.trim().isEmpty()) && (password == null || password.trim().isEmpty())) {
            request.setAttribute("U", "Both fields cannot be kept empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            out.close();
            return;
        } else if (password == null || password.trim().isEmpty()) {
            request.setAttribute("E", "Password field cannot be kept empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            out.close();
            return;
        } else if (name == null || name.trim().isEmpty()) {
            request.setAttribute("Error", "User Login Id field cannot be kept empty");
            request.getRequestDispatcher("index1.jsp").include(request, response);
            out.close();
            return;
        }

        // Database logic
        try (Connection con = Serv.get()) {

            // ✅ Validate user with WHERE clause
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM UserData WHERE email = ? AND password = ?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ User authenticated - Get user's name from database
                String userName = rs.getString("name"); // Assuming 'name' column exists
                
                // Now fetch course completion and certificates
                PreparedStatement courseStmt = con.prepareStatement(
                        "SELECT COURSE_ID, COURSE_NAME, MARK FROM course WHERE email = ?");
                courseStmt.setString(1, name);
                ResultSet courseRs = courseStmt.executeQuery();

                java.util.Set<String> completedCourses = new java.util.HashSet<>();
                java.util.Set<String> certificates = new java.util.HashSet<>();

                while (courseRs.next()) {
                    String courseId = courseRs.getString("COURSE_ID");
                    int mark = courseRs.getInt("MARK");

                    // Add to completed courses
                    completedCourses.add(courseId);

                    // If mark >= 30, add to certificates
                    if (mark >= 30) {
                        certificates.add(courseId);
                    }
                }

                // Set session attributes
                session.setAttribute("CompletedCoursesCount", completedCourses.size());
                session.setAttribute("CertificatesCount", certificates.size());
                session.setAttribute("CompletedCourses", completedCourses);
                session.setAttribute("Certificates", certificates);

                courseRs.close();
                courseStmt.close();
                rs.close();
                ps.close();

                // ========================================
                // 🎉 BEAUTIFUL LOGIN SUCCESS MESSAGE
                // ========================================
                
                out.print("<!DOCTYPE html><html><head>");
                out.print("<meta charset='UTF-8'>");
                out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.print("<link href='https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;600;700;800&display=swap' rel='stylesheet'>");
                out.print("</head><body style='margin:0; font-family: \"Plus Jakarta Sans\", sans-serif;'>");
                
                // Overlay
                out.print("<div id='loginSuccessOverlay' style='position: fixed; top: 0; left: 0; width: 100%; height: 100%; "
                    + "background: rgba(15, 23, 42, 0.95); backdrop-filter: blur(10px); z-index: 9998; "
                    + "display: flex; align-items: center; justify-content: center;'>");
                
                // Success Modal
                out.print("<div id='loginSuccessModal' style='background: white; padding: 50px 60px; "
                    + "border-radius: 30px; box-shadow: 0 30px 80px rgba(0,0,0,0.4); text-align: center; "
                    + "max-width: 500px; animation: modalPop 0.5s cubic-bezier(0.68, -0.55, 0.265, 1.55);'>");
                
                // Animations
                out.print("<style>"
                    + "@keyframes modalPop { "
                    + "  from { opacity: 0; transform: scale(0.5) translateY(-100px); } "
                    + "  to { opacity: 1; transform: scale(1) translateY(0); } "
                    + "}"
                    + "@keyframes checkDraw { "
                    + "  0% { stroke-dashoffset: 100; } "
                    + "  100% { stroke-dashoffset: 0; } "
                    + "}"
                    + "@keyframes circleFill { "
                    + "  0% { transform: scale(0); opacity: 0; } "
                    + "  50% { transform: scale(1.1); } "
                    + "  100% { transform: scale(1); opacity: 1; } "
                    + "}"
                    + "@keyframes pulse { "
                    + "  0%, 100% { transform: scale(1); } "
                    + "  50% { transform: scale(1.05); } "
                    + "}"
                    + "@keyframes shine { "
                    + "  0% { background-position: -200px; } "
                    + "  100% { background-position: 200px; } "
                    + "}"
                    + "</style>");
                
                // Success Icon with Animation
                out.print("<div style='position: relative; width: 120px; height: 120px; margin: 0 auto 30px;'>");
                
                // Circular background
                out.print("<div style='position: absolute; width: 120px; height: 120px; border-radius: 50%; "
                    + "background: linear-gradient(135deg, #10b981 0%, #059669 100%); "
                    + "animation: circleFill 0.6s ease-out 0.2s backwards; "
                    + "box-shadow: 0 10px 40px rgba(16, 185, 129, 0.4);'></div>");
                
                // Checkmark SVG
                out.print("<svg style='position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);' "
                    + "width='70' height='70' viewBox='0 0 70 70'>"
                    + "<path d='M15 35 L28 48 L55 21' stroke='white' stroke-width='6' "
                    + "fill='none' stroke-linecap='round' stroke-linejoin='round' "
                    + "stroke-dasharray='100' stroke-dashoffset='100' "
                    + "style='animation: checkDraw 0.6s ease-out 0.5s forwards;'/></svg>");
                
                out.print("</div>");
                
                // Success Text
                out.print("<h1 style='color: #0f172a; font-size: 2.5rem; font-weight: 800; "
                    + "margin: 0 0 15px 0; line-height: 1.2;'>Welcome Back!</h1>");
                
                out.print("<p style='color: #10b981; font-size: 1.3rem; font-weight: 600; "
                    + "margin: 0 0 10px 0;'>Login Successful</p>");
                
                out.print("<p style='color: #64748b; font-size: 1.1rem; margin: 0 0 35px 0; "
                    + "line-height: 1.6;'>Hello <strong style='color: #0f172a;'>" + userName + "</strong>!<br>"
                    + "You're being redirected to your dashboard...</p>");
                
                // Stats Cards (if available)
                if (completedCourses.size() > 0 || certificates.size() > 0) {
                    out.print("<div style='display: flex; gap: 20px; justify-content: center; margin-bottom: 30px;'>");
                    
                    // Completed Courses
                    out.print("<div style='background: linear-gradient(135deg, #eff6ff 0%, #dbeafe 100%); "
                        + "padding: 20px 30px; border-radius: 16px; text-align: center; flex: 1;'>");
                    out.print("<div style='font-size: 2rem; font-weight: 800; color: #2563eb;'>" 
                        + completedCourses.size() + "</div>");
                    out.print("<div style='font-size: 0.85rem; color: #64748b; font-weight: 600;'>Courses</div>");
                    out.print("</div>");
                    
                    // Certificates
                    out.print("<div style='background: linear-gradient(135deg, #fefce8 0%, #fef3c7 100%); "
                        + "padding: 20px 30px; border-radius: 16px; text-align: center; flex: 1;'>");
                    out.print("<div style='font-size: 2rem; font-weight: 800; color: #f59e0b;'>" 
                        + certificates.size() + "</div>");
                    out.print("<div style='font-size: 0.85rem; color: #64748b; font-weight: 600;'>Certificates</div>");
                    out.print("</div>");
                    
                    out.print("</div>");
                }
                
                // Loading Bar
                out.print("<div style='width: 100%; height: 6px; background: #e2e8f0; "
                    + "border-radius: 10px; overflow: hidden; margin-top: 25px;'>");
                out.print("<div style='height: 100%; background: linear-gradient(90deg, #2563eb, #10b981); "
                    + "border-radius: 10px; animation: loadBar 2s ease-out forwards;'></div>");
                out.print("</div>");
                
                out.print("<style>"
                    + "@keyframes loadBar { "
                    + "  from { width: 0%; } "
                    + "  to { width: 100%; } "
                    + "}"
                    + "</style>");
                
                out.print("</div>"); // Close modal
                out.print("</div>"); // Close overlay
                
                // Auto-redirect script
                out.print("<script>"
                    + "setTimeout(function() { "
                    + "  window.location.href = 'Frame.jsp'; "
                    + "}, 2000);" // 2 seconds delay
                    + "</script>");
                
                out.print("</body></html>");

            } else {
                // Invalid login
                rs.close();
                ps.close();
                request.setAttribute("Invalid", "User Login Id or Password is incorrect");
                request.getRequestDispatcher("index1.jsp").include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color: red;'>Error: " + e.getMessage() + "</h3>");
        } finally {
            out.close();
        }
    }
}