package User;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PaymentProcess")
public class PaymentProcess extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
   
        String email = (String) session.getAttribute("User");
        String course = request.getParameter("course");
        int price = Integer.parseInt(request.getParameter("price"));

        try {
            Connection conn = Conec.Serv.get();

            // Here you can integrate payment API, or just simulate payment
            boolean paymentSuccess = true; // simulate payment

            if (paymentSuccess) {
                // Update DB → mark user as paid
                PreparedStatement ps = conn.prepareStatement(
                    "UPDATE UserData SET paid = 1 WHERE email = ?"
                );
                ps.setString(1, email);
                ps.executeUpdate();

                // Redirect user to the course page
                if ("AIML".equals(course)) {
                    response.sendRedirect("list7.html");
                } else if ("AWS/Azure Cloud".equals(course)) {
                    response.sendRedirect("Cloud.html");
                } else {
                    response.sendRedirect("Frame.jsp");
                }

                ps.close();
            } else {
                response.getWriter().println("Payment failed! Try again.");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
