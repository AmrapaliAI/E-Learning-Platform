package User; // Must be your correct package

public class NewsArticle {
    // These variable names MUST match the JSON keys exactly for GSON mapping
    private String title;
    private String description;
    private String url;
    private String urlToImage; // For the image source
    private String publishedAt; // For the date
    private Source source; // Nested class for the source name

    // Nested class to map the source object
    public static class Source {
        private String name;
        public String getName() { return name; } // Getter for JSP: ${article.source.name}
    }

    // --- Getters for JSP (Expression Language access: ${article.propertyName}) ---
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getUrl() { return url; }
    public String getUrlToImage() { return urlToImage; } // Used by ${article.urlToImage}
    public String getPublishedAt() { return publishedAt; } // Used by ${article.publishedAt}
    
    // Custom getter to easily access the source name in the JSP
    public String getSourceName() { 
        return source != null ? source.getName() : "Unknown Source";
    }
}