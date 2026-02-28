<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Removed: taglib prefix="fn" --%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Programming Course News</title>
    <link rel="stylesheet" href="Style.css">
    <link rel="stylesheet" href="Amra.css">
</head>
<body>

    <header>
        <h1>Latest Programming News for Your Courses</h1>
    </header>

    <div class="news-container" id="news-container">
        
        <c:choose>
            <c:when test="${not empty requestScope.errorMsg}">
                <p class="error">${requestScope.errorMsg}</p>
            </c:when>
            
            <%-- Use JSTL to check if the LIST of Java objects exists --%>
            <c:when test="${not empty requestScope.newsList}">
                
                <%-- Iterate directly over the List<NewsArticle> objects --%>
                <c:forEach var="article" items="${requestScope.newsList}">
                    <div class="news-card">
                        
                        <%-- Display Image (Access properties via JavaBeans standards) --%>
                        <div class="card-image-wrapper">
                            <img src="${article.urlToImage}" 
                                 alt="${article.title}" class="card-image"
                                 onerror="this.onerror=null; this.src='images/default-programming.jpg';"> 
                                 <%-- Added onerror for missing images --%>
                        </div>
                        
                        <div class="card-content">
                            <%-- Display Title and link --%>
                            <a href="${article.url}" target="_blank" class="card-title">
                                <h3>${article.title}</h3>
                            </a>
                            
                            <%-- Display Description --%>
                            <p class="card-description">${article.description || 'Click to read full article...'}</p>
                            
                            <div class="card-footer">
                                <%-- Display Source and Date --%>
                                <span class="card-source">${article.sourceName || 'Unknown Source'}</span>
                                <span class="card-date">${article.publishedAt}</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </c:when>
            <c:otherwise>
                 <p>No new articles found for the selected programming topics.</p>
            </c:otherwise>
        </c:choose>
        
    </div>
    
    <link rel="stylesheet" href="css/style.css">

</body>
</html>