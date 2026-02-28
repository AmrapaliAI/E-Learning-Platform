package User;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizStartServlet")
public class QuizStartServlet extends HttpServlet { 

    private QuestionDAO questionDAO = new QuestionDAO();
    // Maximum number of questions to display per quiz run.
    private static final int MAX_QUIZ_QUESTIONS = 40; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
        // 1. Get the selected course name from the request parameter (e.g., from index1.jsp link)
        String courseName = request.getParameter("course");
        int id = Integer.parseInt(request.getParameter("id"));


        if (courseName == null || courseName.trim().isEmpty()) {
            // Error handling: If no course is selected, redirect back to selection page.
            response.sendRedirect("index1.jsp?error=NoCourseSelected");
            return;
        }
            
        // 2. Fetch ALL questions ONLY for the selected course using the filtered DAO method
        List<Question> allQuestions = questionDAO.getQuestionsByCourse(courseName); 
        
        if (allQuestions != null && !allQuestions.isEmpty()) {
            
            // --- Randomization and Subset Selection Logic ---
            
            // 3. Shuffle the ENTIRE list to randomize the pool order.
            // This ensures that the subset selection is truly random.
            Collections.shuffle(allQuestions); 
            
            // 4. Determine the actual size of the quiz. Use the smaller of the two: 
            //    the total number of questions available or the defined maximum (30).
            int quizSize = Math.min(allQuestions.size(), MAX_QUIZ_QUESTIONS);
            
            // 5. Select the random subset (the first 'quizSize' questions from the shuffled list).
            List<Question> quizQuestions = allQuestions.subList(0, quizSize);

            // --- Session Setup ---
            
            // 6. Store the shuffled subset, the course name, and initialize score tracking in the session.
            HttpSession session = request.getSession(); 
            
            session.setAttribute("currentQuizQuestions", quizQuestions);
            session.setAttribute("currentCourse", courseName); // Store course for results display
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("id", id);// Start at the first question
            session.setAttribute("score", 0);                  // Initialize score
            
            System.out.println("Starting quiz for course: " + courseName + " with " + quizQuestions.size() + " questions.");

            // 7. Redirect the user to the quiz page.
            response.sendRedirect("test.jsp"); 
            
        } else {
            // Handle case where no questions are found for the selected course
            System.err.println("No questions found for course: " + courseName);
            response.getWriter().println("Error: Quiz data not available for course: " + courseName);
        }
    }
}