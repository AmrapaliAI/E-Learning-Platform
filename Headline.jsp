<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Programming Course News Headlines</title>
    <link rel="stylesheet" href="Style.css">
    <style>
        /* Optional: Style the marquee container */
        .marquee-container {
            border: 1px solid #ddd;
            padding: 5px;
            background-color: #f9f9f9;
            width: 90%; /* Make it span most of the page */
            margin: 20px auto;
        }
        .headline-link {
            font-size: 1.1em;
            color: #0056b3;
            text-decoration: none;
            /* Add some spacing so headlines don't run into each other */
            padding-right: 40px; 
        }
        .headline-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <header>
        <h1>Latest Programming Headlines (Scrolling)</h1>
    </header>

    <div class="news-container">
        
        <c:choose>
            <c:when test="${not empty requestScope.errorMsg}">
                <p class="error">${requestScope.errorMsg}</p>
            </c:when>
            
            <c:when test="${not empty requestScope.newsList}">
                
                <div class="marquee-container">
                    
                    <marquee behavior="scroll" direction="left" scrollamount="4" onmouseover="this.stop()" onmouseout="this.start()">
                        
                        <c:forEach var="article" items="${requestScope.newsList}">
                            
                            <a href="${article.url}" target="_blank" class="headline-link">
                                **${article.title}** &nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; </a>
                            
                        </c:forEach>
                        
                    </marquee>
                </div>
                </c:when>
            <c:otherwise>
                 <p>No new programming headlines found.</p>
            </c:otherwise>
        </c:choose>
        <jsp:include page="index1.jsp"></jsp:include>
        
    </div>
</body>
</html>