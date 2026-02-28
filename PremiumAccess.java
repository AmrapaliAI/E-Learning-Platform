package User;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PremiumAccess")
public class PremiumAccess extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);


        String email = (String) session.getAttribute("User");
        String course = request.getParameter("course"); // list7 / list8

        // Define course prices
        int coursePrice = 0;
        if ("AIML".equals(course)) {
            coursePrice = 4999;
        } else if ("AWS/Azure Cloud".equals(course)) {
            coursePrice = 3999;
        } else {
            response.sendRedirect("Frame.jsp");
            return;
        }

        try {
            Connection conn = Conec.Serv.get();

            // Check if user paid for this specific course
            PreparedStatement ps = conn.prepareStatement(
                "SELECT paid FROM UserCoursePayments WHERE email = ? AND course_id = ?");
            ps.setString(1, email);
            ps.setString(2, course);

            ResultSet rs = ps.executeQuery();

            boolean paid = false;
            if (rs.next()) {
                paid = rs.getBoolean("paid");
            }

            if (paid) {
                // User already paid → open course
                if ("AIML".equals(course)) {
                    response.sendRedirect("list7.html");
                } else if ("AWS/Azure Cloud".equals(course)) {
                    response.sendRedirect("Cloud.html");
                }
            } else {
                // Not paid → send to Payment.jsp with price info
                session.setAttribute("selectedCourse", course);
                session.setAttribute("coursePrice", coursePrice);
                response.sendRedirect("Payment.jsp");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
