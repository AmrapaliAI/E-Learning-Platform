package User;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ChatBotServlet")
public class ChatBotServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private QuestionDAO1 dao;

    // Courses mapping
    private static final Map<String, String> KEYWORDS = new LinkedHashMap<>();
    static {
        KEYWORDS.put("javascript", "HTML/CSS/JavaScript");
        KEYWORDS.put("html", "HTML/CSS/JavaScript");
        KEYWORDS.put("css", "HTML/CSS/JavaScript");
        KEYWORDS.put("jsp", "JSP/Servlet");
        KEYWORDS.put("servlet", "JSP/Servlet");
        KEYWORDS.put("java", "Core Java");
        KEYWORDS.put("python", "Python");
        KEYWORDS.put("dbms", "Database Management System");
        KEYWORDS.put("database", "Database Management System");
        KEYWORDS.put("ai", "Artificial Intelligence");
        KEYWORDS.put("ml", "Artificial Intelligence");
    }

    @Override
    public void init() {
        dao = new QuestionDAO1();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String msg = Optional.ofNullable(request.getParameter("message"))
                .orElse("")
                .toLowerCase()
                .trim();

        HttpSession session = request.getSession();

        // Default number of questions = 1
        int requestedCount = 1;
        String currentCourse = null;

        // Parse if user typed like "4 java" or "3 python"
        String[] parts = msg.split("\\s+");
        if (parts.length >= 2) {
            try {
                requestedCount = Integer.parseInt(parts[0]);
                msg = parts[1]; // course keyword
            } catch (NumberFormatException e) {
                requestedCount = 1; // fallback
            }
        }

        // Detect course
        currentCourse = detectCourse(msg);
        if (currentCourse == null) {
            writeText(response, "Try: java, 4 python, 3 dbms");
            return;
        }

        // Get questions from database
        List<Question> quizQuestions = dao.getQuestionsByCourse(currentCourse);
        if (quizQuestions == null || quizQuestions.isEmpty()) {
            writeText(response, "No questions available for " + currentCourse);
            return;
        }

        // Shuffle and limit to requested count
        Collections.shuffle(quizQuestions);
        int actualCount = Math.min(requestedCount, quizQuestions.size());
        List<Question> selectedQuestions = quizQuestions.subList(0, actualCount);

        // Build JSON for questions
        StringBuilder json = new StringBuilder();
        json.append("{\"type\":\"questions\",\"data\":[");
        for (int i = 0; i < selectedQuestions.size(); i++) {
            Question q = selectedQuestions.get(i);
            if (i > 0) json.append(",");
            json.append("{");
            json.append("\"id\":").append(q.getId()).append(",");
            json.append("\"text\":\"").append(escape(q.getQuestionText())).append("\",");
            json.append("\"options\":[");
            List<String> ops = q.getOptions();
            for (int j = 0; j < ops.size(); j++) {
                if (j > 0) json.append(",");
                json.append("\"").append(escape(ops.get(j))).append("\"");
            }
            json.append("],");
            json.append("\"correctIndex\":").append(q.getCorrectAnswerIndex());
            json.append("}");
        }
        json.append("],\"totalQuestions\":").append(actualCount).append("}");

        response.getWriter().write(json.toString());
    }

    private String detectCourse(String msg) {
        for (String key : KEYWORDS.keySet()) {
            if (msg.contains(key)) return KEYWORDS.get(key);
        }
        return null;
    }

    private void writeText(HttpServletResponse res, String text) throws IOException {
        res.getWriter().write("{\"type\":\"text\",\"message\":\"" + escape(text) + "\"}");
    }

    private String escape(String s) {
        return s == null ? "" : s.replace("\\", "\\\\").replace("\"", "\\\"")
                                 .replace("\n", "\\n").replace("\r", "");
    }

    @Override
    public void destroy() {
        if (dao != null) dao.close();
    }
}