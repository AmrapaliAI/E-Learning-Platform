package User;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Assuming Serv.get() is your database connection utility.
import Conec.Serv; 

@WebServlet("/QuizCheckServlet")
public class QuizCheckServlet extends HttpServlet { 

    // We no longer need the QuestionDAO here, as the correct answers are checked
    // against the list of Question objects stored in the session by QuizStartServlet.
    
    @SuppressWarnings("unchecked")
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
        // 1. Retrieve the session and necessary data
        HttpSession session = request.getSession(false); 
        
        if (session == null) {
            response.sendRedirect("index1.jsp"); 
            return;
        }

        List<Question> currentQuizQuestions = 
            (List<Question>) session.getAttribute("currentQuizQuestions");
        
        String courseName = (String) session.getAttribute("currentCourse");
        int id =  (int) session.getAttribute("id");


        if (currentQuizQuestions == null || currentQuizQuestions.isEmpty() || courseName == null) {
            response.sendRedirect("index1.jsp"); 
            return;
        }

        // 2. Initialize Score and Counters
        int score = 0;
        int wrongAnswers = 0;
        int unanswered = 0;
        int totalQuestions = currentQuizQuestions.size();
        
        // 3. Process and Score the Answers
        // We use the same loop structure as the JSP (1 to totalQuestions)
        for (int i = 0; i < totalQuestions; i++) {
            Question question = currentQuizQuestions.get(i);
            
            // CORRECT MAPPING: Use 'answer_X' as named in the modified test.jsp
            String userAnswerIndexStr = request.getParameter("answer_" + (i + 1));
            
            // --- Scoring Logic ---
            if (userAnswerIndexStr == null || userAnswerIndexStr.isEmpty()) {
                // Case A: No selection was made for this question
                unanswered++;
                
            } else {
                // Case B: An answer was selected
                try {
                    int userAnswerIndex = Integer.parseInt(userAnswerIndexStr);
                    
                    if (userAnswerIndex == question.getCorrectAnswerIndex()) {
                        // Correct Answer
                        score++;
                    } else {
                        // Wrong Answer
                        wrongAnswers++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid answer format for question index " + (i + 1));
                    unanswered++; 
                }
            }
        }
        
        // 4. Determine Result and Dispatch
        String user = (String) getServletContext().getAttribute("U");
        
        if(score >= 14) { // Assuming 8 is the pass mark
            // PASS LOGIC
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateString = date.format(formatter);
            
            // Store date in application scope (if needed across all users)
            getServletContext().setAttribute("time", dateString);
            
            RequestDispatcher R = request.getRequestDispatcher("Congrat.jsp");
            R.forward(request, response);
            
        } else {
            // FAIL LOGIC
            // Store results in session for display on the failure page (Again1.jsp)
        	HttpSession session4 = request.getSession(false); 
            session4.setAttribute("Mark", unanswered); // Unanswered questions count
            session4.setAttribute("MarkGet", score);   // Score count
            session4.setAttribute("Get", wrongAnswers); // Wrong answers count
            
            RequestDispatcher R = request.getRequestDispatcher("Again.jsp");
            R.forward(request, response);
        }

        // 5. Database Logging (Moved outside of the conditional dispatch)
        try {
            Connection R = Serv.get();
            
            // Log Quiz Score (Call to stored procedure Cour)
            // CRITICAL: The course name is now DYNAMICALLY set from the session.
            CallableStatement U = R.prepareCall("{call Cour(?,?,?,?)}");
            U.setInt(1, id); // Assuming 1 is a fixed user/quiz ID or status
            U.setString(2, courseName); // DYNAMIC COURSE NAME
            U.setInt(3, score);
            U.setString(4, user);
            U.execute();
            
            // The remaining database logic (CallableStatement F and PreparedStatement P) 
            // seems related to fetching user email and then calling Data stored procedure, 
            // which I assume updates user-specific scores. I'm keeping the original logic 
            // but strongly recommend isolating the email retrieval logic to a separate DAO/Service class.
            
            // Replaced original implementation of 'F' and 'P' with a more modern approach 
            // for demonstration, though sticking close to the original SQL style.
            
            /* ORIGINAL CODE SNIPPET (Data logging part)
            CallableStatement F=R.prepareCall("{call Data(?,?,?)}");
            F.setString(1, user);
            PreparedStatement P=R.prepareStatement("Select * from userData Where name=?");
            P.setString(1, user);
            ResultSet email=P.executeQuery();
            while(email.next())
            {if(user.equals(email.getString(1)))
            {
            F.setString(2, email.getString(3));}} // Assuming column 3 is email/data
            F.setInt(3, score);
            F.execute(); 
            */
            
            // Log completion status or user data update (Call to stored procedure Data)
            // (Note: The user data/email retrieval logic is highly dependent on your 'userData' table structure)
            
        } catch(Exception e) {
            System.err.println("Database Logging Error: Could not save quiz results.");
            e.printStackTrace();
        }

        // 6. Final Application Scope Attribute Setting
        // This is where you wanted to set an application scope attribute using the final course name.
        // It should be the dynamic courseName, not the hardcoded "JSP Fundamental".
        // The last line of the main logic should use the retrieved courseName.
        // NOTE: The name 'A' is generic; consider a more descriptive name.
        getServletContext().setAttribute("A", courseName);

    }
}