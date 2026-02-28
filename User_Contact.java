package User;
import Conec.Serv;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conec.Serv;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation for handling contact form submissions.
 * This servlet connects to an SQL database (defaulting to MySQL configuration)
 * and inserts the user's message details into a dedicated table.
 *
 * NOTE: For production use, database credentials should be stored securely
 * (e.g., environment variables or configuration files), not directly in the code.
 *
 * IMPORTANT: Replace the database configuration and ensure your database table exists.
 * Create the table with a command similar to:
 CREATE TABLE contact_messages (
  id NUMBER(10)PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  subject VARCHAR(100),
  message varchar2(4000) NOT NULL,
  submission_date DATE DEFAULT SYSDATE
  );
 */
@WebServlet("/User_Contact") // This maps the servlet to the URL /ContactServlet
public class User_Contact extends HttpServlet {
    
    
       
    // Initialize the database driver when the servlet loads
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type and character encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 1. Retrieve form parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        // Initialize connection and statement objects
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 2. Establish connection to the database
       
			Connection Conn=Serv.get();
		
		 String INSERT_SQL = "INSERT INTO contact_messages(name, email, subject, message) VALUES (?, ?, ?, ?)"; 

            // 3. Prepare the SQL insertion statement
            PreparedStatement Stmt = Conn.prepareStatement(INSERT_SQL);
            Stmt.setString(1, name);
            Stmt.setString(2, email);
            Stmt.setString(3, subject);
            Stmt.setString(4, message);
       
     

            // 4. Execute the statement
            int rowsAffected = Stmt.executeUpdate();

            // 5. Send a success response back to the user
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Submission Status</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; text-align: center; padding-top: 50px; background-color: #e6f7ff; }");
            out.println(".message-box { background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; padding: 20px; border-radius: 8px; max-width: 500px; margin: 0 auto; }");
            out.println("a { color: #007bff; text-decoration: none; } a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head><body>");
            
            if (rowsAffected > 0) {
                out.println("<div class='message-box'>");
                out.println("<h2>&#x2714; Thank You, " + name + "!</h2>");
                out.println("<p>Your message has been successfully received and logged.</p>");
                out.println("<p>We aim to respond to your inquiry (Subject: " + subject + ") within 24-48 business hours.</p>");
                out.println("<p><a href=\"index1.jsp\">Return to Homepage</a></p>");
                out.println("</div>");
            } else {
                 out.println("<div class='message-box' style='background-color: #f8d7da; color: #721c24; border-color: #f5c6cb;'>");
                 out.println("<h2>&#x2716; Submission Failed</h2>");
                 out.println("<p>We could not process your message. Please try again later.</p>");
                 out.println("<p><a href=\"index1.jsp\">Go Back to Contact Form</a></p>");
                 out.println("</div>");
            }
            
            out.println("</body></html>");

        } catch (Exception e) {
            // Log the error to the console
            System.err.println("Database error: " + e.getMessage());
            
            // Send an error response to the user
            out.println("<div class='message-box' style='background-color: #f8d7da; color: #721c24; border-color: #f5c6cb;'>");
            out.println("<h2>&#x2716; Server Error</h2>");
            out.println("<p>A critical error occurred while saving your message. Please check the server logs for details.</p>");
            out.println("<p>Error Detail: " + e.getMessage() + "</p>");
            out.println("<p><a href=\"index1.jsp\">Go Back to Contact Form</a></p>");
            out.println("</div>");
            
        } finally {
            // 6. Close JDBC resources safely
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) { 
                System.err.println("Error closing statement: " + se.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                System.err.println("Error closing connection: " + se.getMessage());
            }
        }
    }
}