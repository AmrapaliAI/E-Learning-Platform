<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - Something Went Wrong</title>
    <link rel="stylesheet" href="css/style.css"> 
    <style>
        .error-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            border: 1px solid #ff4d4d;
            border-radius: 8px;
            background-color: #ffe6e6;
            text-align: center;
        }
        .error-title {
            color: #cc0000;
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1 class="error-title">❌ Oh No! An Error Occurred</h1>
        <hr>
        
        <c:choose>
            <c:when test="${not empty requestScope.errorMsg}">
                <p>We encountered an issue while trying to fetch the news data. Please see the details below:</p>
                <p style="font-style: italic; color: #333;">
                    <strong>Error Details:</strong> ${requestScope.errorMsg}
                </p>
            </c:when>
            <c:otherwise>
                <p>Something went wrong, and we couldn't load the requested page. Please try navigating to the home page.</p>
            </c:otherwise>
        </c:choose>

        <p>
            <a href="/Knowledge_Check/index.jsp" style="color: #007bff; text-decoration: none;">Go to Home Page</a>
        </p>
    </div>

</body>
</html>