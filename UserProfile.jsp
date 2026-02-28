<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
/* ===== Page Background ===== */
body{
    background-image: url("data-sciences.jpg");
    background-size: cover;
    background-position: center;
    font-family: "Segoe UI", Tahoma, sans-serif;
}

/* ===== Profile Card ===== */
.U{
    width: 720px;
    margin: 60px auto;
    padding: 45px 50px;
    background: rgba(255,255,255,0.92);
    border-radius: 18px;
    border: 3px solid #f59e0b;
    box-shadow: 0 25px 45px rgba(0,0,0,0.25);
}

/* ===== Headings ===== */
h1{
    letter-spacing: 2px;
    text-shadow: 0 2px 8px rgba(255,165,0,0.5);
}

/* ===== Labels Text ===== */
.U div{
    font-size: 15px;
    font-weight: 600;
    color: #1e40af;
}

/* ===== Input Fields ===== */
.Font{
    height: 36px;
    width: 320px;
    padding-left: 14px;
    border-radius: 20px;
    border: 2px solid #3b82f6;
    font-size: 14px;
    transition: 0.3s ease;
    background: #f8fafc;
}

/* ===== Input Focus Effect ===== */
.Font:focus{
    outline: none;
    border-color: #a855f7;
    box-shadow: 0 0 0 4px rgba(168,85,247,0.25);
    background: #ffffff;
}

/* ===== Input Active ===== */
.Font:active{
    transform: scale(0.98);
}

/* ===== Links as Buttons ===== */
a{
    display: inline-block;
    margin: 20px;
    padding: 12px 28px;
    font-size: 18px;
    font-weight: bold;
    color: #f97316;
    text-decoration: none;
    border-radius: 30px;
    border: 2px solid #facc15;
    background: linear-gradient(135deg,#fff7ed,#ffedd5);
    transition: 0.3s ease;
}

/* ===== Button Hover ===== */
a:hover{
    color: white;
    background: linear-gradient(135deg,#f97316,#fb7185);
    box-shadow: 0 10px 25px rgba(249,115,22,0.5);
    transform: translateY(-3px);
}

/* ===== Responsive ===== */
@media(max-width:768px){
    .U{
        width: 90%;
        padding: 30px;
    }
    .Font{
        width: 100%;
        margin-bottom: 12px;
    }
}
</style>

</head>
<body>
<%@page import="java.sql.*"%>
<%@page import="Conec.Serv" %>
<%
Connection C=Serv.get();
 
String user=(String)application.getAttribute("U");
 PreparedStatement I=C.prepareStatement("Select * from UserData where email=?");
 I.setString(1,user);
 ResultSet F=I.executeQuery();
 out.print("<Center><H1 style='color:orange;text-algin:Center;'>User Profile</H1></Center>");
 out.print("<a href='UserProfile1.jsp'style='border:2px solid yellow;height:100;width:300;font-size:31px; Color:Orange;' >Edit</a>");
 out.print("<CENtEr><div class='U'>");
 while(F.next())
 {String u=F.getString(1);
	out.print("<DIV Style='Color:Blue;'>"); out.println("Full Name<P Style='diSplay:inline;Margin-left:267px;'>Email</P><BR><input type='text'Class='Font' value=\""+u+" \"name='Id'></input><P Style='diSplay:inline;Margin-left:10px;'><input type='text' Class='Font' value="+F.getString(3)+"></input></P><BR>");
	 out.println("<BR>Mobile Number<P Style='diSplay:inline;Margin-left:239px;'>Class</P><BR><input type='text' class='Font' name='Borr' value="+F.getString(7)+"></input><P Style='diSplay:inline;Margin-left:10px;'><input type='text' class='Font' value="+F.getString(5)+"></input></P><BR>");


		
		
		out.println("<BR>Address<BR>");
		out.print("<input type='text' class='Font' value="+F.getString(4)+"></input>");out.print("</DIV>");
		
		break;
 }
out.print("</div></CENtEr>");

 %>
 <a href="Frame.jsp" style="border:2px solid yellow;height:100;width:300;font-size:31px; Color:Orange;">Go to Main Page</a>
</body>
</html>