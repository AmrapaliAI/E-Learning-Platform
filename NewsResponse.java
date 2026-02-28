package User; // Must be your correct package

import java.util.List;

public class NewsResponse {
    // These variable names MUST match the JSON keys exactly for GSON mapping
    private String status;
    private List<NewsArticle> articles;

    // Getter for the list of articles (Used by Servlet and JSTL)
    public List<NewsArticle> getArticles() { return articles; }
}