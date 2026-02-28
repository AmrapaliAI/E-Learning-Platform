package User;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UnifiedChatServlet")
public class UnifiedChatServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String msg = req.getParameter("message").toLowerCase();
        res.setContentType("text/plain");

        if (isMath(msg)) {
            res.getWriter().write(handleMath(msg));
        } else {
            res.getWriter().write(handleProgramming(msg));
        }
    }

    private boolean isMath(String msg) {
        return msg.matches(".*\\d+.*") ||
               msg.contains("solve") ||
               msg.contains("equation") ||
               msg.contains("integral") ||
               msg.contains("derivative") ||
               msg.contains("algebra");
    }

    private String handleMath(String msg) {
        if (msg.contains("2+2")) return "2 + 2 = 4";
        return "📐 Math detected. Please provide a specific problem.";
    }

    private String handleProgramming(String msg) {
        if (msg.contains("java"))
            return "Java is an object-oriented programming language.";
        if (msg.contains("python"))
            return "Python is great for AI, data science, and automation.";
        return "💻 Programming detected. Ask about Java, Python, or JS.";
    }
}
