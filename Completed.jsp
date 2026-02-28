<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Courses</title>

<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-image: url('data-sciences.jpg');
    background-size: cover;
    background-attachment: fixed;
    margin: 0;
    padding: 0;
    color: #fff;
    text-align: center;
}

/* ===== Heading ===== */
h1 {
    color: orange;
    text-shadow: 2px 2px 5px #000;
}

/* ===== Course Card ===== */
.course-card {
    display: inline-block;
    background: rgba(0,0,0,0.65);
    border: 4px solid yellow;
    border-bottom: 7px solid #2563eb;
    border-radius: 16px;
    margin: 20px;
    padding: 18px;
    width: 300px;
    transition: all 0.35s ease;
}

.course-card:hover {
    transform: translateY(-10px);
    box-shadow: 0 15px 30px rgba(0,0,0,0.8);
}

/* ===== Course Image ===== */
.course-card img {
    width: 100%;
    height: 200px;
    border-radius: 12px;
    margin-bottom: 12px;
    transition: transform 0.3s ease;
}

.course-card img:hover {
    transform: scale(1.06);
}

/* ===== Certificate Button ===== */
.cert-btn {
    margin-top: 10px;
    padding: 10px 22px;
    font-size: 16px;
    font-weight: bold;
    border-radius: 22px;
    border: none;
    cursor: pointer;
    color: white;
    background: linear-gradient(135deg,#22c55e,#16a34a);
    box-shadow: 0 8px 18px rgba(34,197,94,0.5);
    transition: all 0.3s ease;
}

.cert-btn:hover {
    transform: translateY(-3px);
    box-shadow: 0 12px 28px rgba(34,197,94,0.7);
}

/* ===== Main Button ===== */
.main-btn {
    display: inline-block;
    margin: 35px auto;
    padding: 15px 35px;
    font-size: 22px;
    font-weight: bold;
    color: orange;
    background: transparent;
    border: 3px solid yellow;
    border-radius: 14px;
    text-decoration: none;
    transition: all 0.3s ease;
}

.main-btn:hover {
    background: yellow;
    color: black;
    border-color: orange;
}
</style>
</head>

<body>

<h1>My Courses</h1>

<%@page import="java.sql.*, java.util.*" %>
<%@page import="Conec.Serv" %>

<%
Connection C = Serv.get();
PreparedStatement F = C.prepareStatement("SELECT * FROM CourseCheck");
ResultSet R = F.executeQuery();

String user = (String)application.getAttribute("U");
Set<Integer> displayedCourses = new HashSet<>();

while(R.next()) {
    if(R.getString(4) != null && R.getString(4).equals(user)) {

        int courseId = R.getInt(1);
        if(displayedCourses.contains(courseId)) continue;
        displayedCourses.add(courseId);

        String courseTitle="", courseImg="", courseLink="",Dateuser="";

        switch(courseId) {
            case 1: courseTitle="JSP Fundamental"; courseImg="JSP.jpg"; courseLink="JavaCourSe.html";Dateuser=R.getString(5); break;
            case 2: courseTitle="Python"; courseImg="Python.jpg"; courseLink="Python.html";Dateuser=R.getString(5); break;
            case 3: courseTitle="Database Management"; courseImg="/Knowledge Check/WebContent/Copilot_20251122_174444.png"; courseLink="Data.html";Dateuser=R.getString(5); break;
            case 4: courseTitle="Indian Constituion"; courseImg="Const.jpg"; courseLink="ConSti.html";Dateuser=R.getString(5); break;
            case 5: courseTitle="Java"; courseImg="java.jpg"; courseLink="Java.html";Dateuser=R.getString(5); break;
            case 6: courseTitle="HTML / CSS / JS"; courseImg="html.jpg"; courseLink="HtmlCSSScript.html"; Dateuser=R.getString(5);break;            
            
            case 7: courseTitle="Artificial Intelligence"; courseImg="AI.jpg"; courseLink="Artificial_Intelligence.html"; Dateuser=R.getString(5);break;
            case 8: courseTitle="AWS Fundamentals"; courseImg="AWZC.png"; courseLink="Aws.html"; Dateuser=R.getString(5);break;
			
            case 9: courseTitle="Azure Fundamentals"; courseImg="Azure.png"; courseLink="Azure.html"; Dateuser=R.getString(5);break;

            case 10: courseTitle="Asp.Net Core"; courseImg="Dot.jpg"; courseLink="DotNetCore.html"; Dateuser=R.getString(5);break;}
%>

<% application.setAttribute("time",Dateuser);%>
<div class="course-card">
    <h1><%= courseTitle %></h1>

    <a href="<%= courseLink %>">
        <img src="<%= courseImg %>" alt="<%= courseTitle %>">
    </a>
       <%
application.setAttribute("A",courseTitle);
%>
    <!-- Download Certificate -->
    <form action="Down">
        <input type="hidden" name="A" value="<%= courseTitle %>">
       


        <button class="cert-btn">Download Certificate</button>
    </form>
</div>

<%
    }
}
C.close();
%>

<br><br>
<a href="Frame.jsp" class="main-btn">Go to Main Page</a>

</body>
</html>
