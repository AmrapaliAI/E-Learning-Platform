package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
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

import Conec.Serv;

/**
 * Servlet implementation class UserProfile1
 */
@WebServlet("/UserProfile1")
public class UserProfile1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String mobile = request.getParameter("M");
        String address = request.getParameter("A");
        String className = request.getParameter("C");

        // ===== VALIDATION =====
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("N", "Name field cannot be empty");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            request.setAttribute("E", "Email field cannot be empty");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        if (mobile == null || mobile.trim().isEmpty()) {
            request.setAttribute("Error", "Mobile number cannot be empty");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        if (address == null || address.trim().isEmpty()) {
            request.setAttribute("A", "Address cannot be empty");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        if (className == null || className.trim().isEmpty()) {
            request.setAttribute("F", "Class field cannot be empty");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        long mobileNo;
        try {
            mobileNo = Long.parseLong(mobile);
        } catch (NumberFormatException e) {
            request.setAttribute("Error", "Mobile number must be numeric");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
            return;
        }

        // ===== DATABASE UPDATE =====
        try (Connection con = Serv.get();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE UserData SET name=?, email=?, AddreS=?, ClaSS_Name=?, MoBile=? WHERE email=?")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, className);
            ps.setLong(5, mobileNo);
            ps.setString(6, email); // WHERE condition

            ps.executeUpdate();

            request.setAttribute("Success", "Profile updated successfully!");
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", "Something went wrong. Please try again.");
            request.getRequestDispatcher("UserProfile1.jsp").forward(request, response);
        }
    }
}
