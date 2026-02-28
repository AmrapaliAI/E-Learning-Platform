package User; // 1. Ensure this is your correct package name

// --- CORRECTED IMPORTS ---
import com.google.gson.Gson; // GSON import
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List; // CORRECT: Use java.util.List for the collection type

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

// NOTE: Remove these imports as they are incorrect or unused:
// import org.apache.http.client.HttpClient; 
// import org.apache.http.client.fluent.Request;
// import java.awt.List; // INCORRECT: java.awt.List is for GUI components!

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
    
    // --- 1. MOVE ALL CONSTANTS TO THE CLASS LEVEL (MUST BE STATIC) ---
    private static final String API_KEY = "6e868cef15364ffcb96079847a7794a1"; 
    private static final String QUERY = "(Artificial Intelligence) OR (Dot Net Core)OR(html OR Hibernate)OR(CSS OR It OR windows Or System)";    private static final String ENCODED_QUERY;
    private static final String API_URL; // Declare the final URL here
    
    // Static initializer block for encoding and URL construction
    static {
        try {
            ENCODED_QUERY = URLEncoder.encode(QUERY, StandardCharsets.UTF_8.toString());
           
            API_URL = 
                    "https://newsapi.org/v2/everything?q=" + ENCODED_QUERY + 
                    "&searchIn=title" + // Restrict to titles for maximum relevance
                    "&language=en&sortBy=publishedAt&pageSize=10&apiKey=" + API_KEY;
          
          
          
        } catch (Exception e) {
            throw new RuntimeException("Error initializing API constants", e);
        }
    }
    // ----------------------------------------------------------------
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 2. httpGet uses the class-level API_URL constant
        HttpGet httpGet = new HttpGet(API_URL);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse apiResponse = httpClient.execute(httpGet)) {

            int statusCode = apiResponse.getStatusLine().getStatusCode();
            
            // 3. CORRECTED: Standard if-else block syntax
            if (statusCode == 200) {
                
                String jsonResponse = EntityUtils.toString(apiResponse.getEntity());
                
                // --- JSON Parsing ---
                Gson gson = new Gson();
                // Ensure NewsResponse and NewsArticle classes are defined in the 'User' package!
                NewsResponse responseObj = gson.fromJson(jsonResponse, NewsResponse.class);
                
                // Get the list of articles from the mapped object
                List<NewsArticle> newsList = responseObj.getArticles();
                
                // Pass the List of NewsArticle objects to the JSP
                request.setAttribute("newsList", newsList); 
                
                // Forward to the display page
                request.getRequestDispatcher("/programmingNews.jsp").forward(request, response);
                
            } else { // Correct placement of 'else' block
                // Handle non-200 responses
                String errorMsg = "API Connection Failed with Status: " + statusCode;
                request.setAttribute("errorMsg", errorMsg);
                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Forward to the error page if any exception occurs (IO, GSON, etc.)
            e.printStackTrace();
            String errorMsg = "An unexpected error occurred: " + e.getMessage();
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}