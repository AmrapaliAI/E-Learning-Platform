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
import org.apache.http.HttpResponse;
import com.google.gson.*;

@WebServlet("/ChatFace")
public class ChatFace extends HttpServlet {
    // Use a specific model endpoint
    private static final String API_URL = 
        "https://api-inference.huggingface.co/models/google/flan-t5-base";
    
    // ⚠️ IMPORTANT: Move to environment variable or web.xml
    private static final String API_TOKEN =  "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";
        
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String question = request.getParameter("question");
        
        // Java 8 compatible string concatenation
        String prompt = "You are an expert teacher. " +
                "Answer questions related to: " +
                "Java, Java 8, Servlets, JSP, HTML, CSS, JavaScript, " +
                "DBMS, AI, Cloud Computing, AWS, Azure, " +
                ".NET Core and Indian Constitution.\n" +
                "Question: " + question;
        
        JsonObject json = new JsonObject();
        json.addProperty("inputs", prompt);
        
        JsonObject parameters = new JsonObject();
        parameters.addProperty("max_new_tokens", 250);
        parameters.addProperty("temperature", 0.7);
        json.add("parameters", parameters);
        
        HttpPost post = new HttpPost(API_URL);
        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_TOKEN);
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(new StringEntity(json.toString(), "UTF-8"));
        
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = client.execute(post);
        
        // Java 8 compatible way to read response
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
        
        JsonElement parsed = JsonParser.parseString(result.toString());
        String answer;
        
        if (parsed.isJsonArray() && parsed.getAsJsonArray().size() > 0) {
            JsonObject firstResult = parsed.getAsJsonArray().get(0).getAsJsonObject();
            answer = firstResult.get("generated_text").getAsString();
            // Remove the prompt from response
            answer = answer.replace(prompt, "").trim();
        } else if (parsed.isJsonObject() && parsed.getAsJsonObject().has("error")) {
            answer = "Model is loading. Please wait 20 seconds and try again.";
        } else {
            answer = "Unexpected response format.";
        }
        
        // Proper JSON escaping
        answer = escapeJson(answer);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("{\"answer\":\"" + answer + "\"}");
    }
    
    // Proper JSON string escaping
    private String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}