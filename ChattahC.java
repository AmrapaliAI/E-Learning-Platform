package User;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.HttpHeaders;
import com.google.gson.*;

@WebServlet("/ChattahC")
public class ChattahC extends HttpServlet {
    private static final String API_URL = 
        "https://api.groq.com/openai/v1/chat/completions";
    private static final String API_TOKEN = 
        "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"; // Get from: https://console.groq.com/keys
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String question = request.getParameter("question");
        
        JsonObject json = new JsonObject();
        json.addProperty("model", "llama-3.3-70b-versatile");
        
        JsonArray messages = new JsonArray();
        
        JsonObject systemMsg = new JsonObject();
        systemMsg.addProperty("role", "system");
        systemMsg.addProperty("content", 
            "You are an expert teacher. Answer questions about: " +
            "Java, Java 8, Servlets, JSP, HTML, CSS, JavaScript, " +
            "DBMS, AI, Cloud Computing, AWS, Azure, .NET Core, and Indian Constitution.");
        messages.add(systemMsg);
        
        JsonObject userMsg = new JsonObject();
        userMsg.addProperty("role", "user");
        userMsg.addProperty("content", question);
        messages.add(userMsg);
        
        json.add("messages", messages);
        json.addProperty("temperature", 0.7);
        json.addProperty("max_tokens", 500);
        
        HttpPost post = new HttpPost(API_URL);
        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_TOKEN);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(new StringEntity(json.toString(), "UTF-8"));
        
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = client.execute(post);
        
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8")
        );
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        client.close();
        
        String answer;
        try {
            JsonObject parsed = JsonParser.parseString(result.toString()).getAsJsonObject();
            answer = parsed.getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content").getAsString();
        } catch (Exception e) {
            answer = "Error: " + e.getMessage();
        }
        
        answer = escapeJson(answer);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("{\"answer\":\"" + answer + "\"}");
    }
    
    private String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}