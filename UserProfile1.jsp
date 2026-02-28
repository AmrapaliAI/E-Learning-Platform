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
    font-family: "Segoe UI", Tahoma, Arial, sans-serif;
}

/* ===== Profile Form Card ===== */
.U{
    width: 720px;
    margin: 60px auto;
    padding: 55px 60px;
    background: rgba(255,255,255,0.95);
    border-radius: 26px;
    border: 3px solid #fb923c;
    box-shadow: 0 35px 70px rgba(0,0,0,0.35);
    animation: slideFade 0.8s ease;
}

/* ===== Card Animation ===== */
@keyframes slideFade{
    from{
        opacity:0;
        transform: translateY(50px);
    }
    to{
        opacity:1;
        transform: translateY(0);
    }
}

/* ===== Labels / Text ===== */
.U div{
    font-size: 15px;
    font-weight: 700;
    color: #1e3a8a;
    letter-spacing: 0.4px;
}

/* ===== Enhanced Input Fields ===== */
input[type="text"],
.Font{
    width: 310px;
    height: 40px;
    padding: 0 16px;
    border-radius: 30px;
    border: 2px solid #60a5fa;
    background: linear-gradient(180deg,#f8fafc,#ffffff);
    font-size: 14px;
    color: #1e293b;
    transition: all 0.35s ease;
    box-shadow: inset 0 2px 6px rgba(0,0,0,0.08);
}

/* ===== Hover Effect ===== */
input[type="text"]:hover,
.Font:hover{
    border-color: #a855f7;
}

/* ===== Focus Glow Effect ===== */
input[type="text"]:focus,
.Font:focus{
    outline: none;
    background: #ffffff;
    border-color: #9333ea;
    box-shadow:
        0 0 0 4px rgba(147,51,234,0.25),
        0 10px 25px rgba(147,51,234,0.35);
    transform: translateY(-1px);
}

/* ===== Submit Button ===== */
input[type="submit"]{
    height: 40px;
    width: 140px;
    border-radius: 25px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
    border: none;
    color: white;
    background: linear-gradient(135deg,#2563eb,#9333ea);
    box-shadow: 0 12px 25px rgba(37,99,235,0.5);
    transition: all 0.3s ease;
}

/* ===== Submit Hover ===== */
input[type="submit"]:hover{
    transform: translateY(-3px);
    box-shadow: 0 18px 35px rgba(147,51,234,0.6);
}

/* ===== Page Heading ===== */
h1{
    font-weight: 900;
    letter-spacing: 2px;
    text-shadow: 0 4px 12px rgba(255,165,0,0.6);
}

/* ===== Link Button ===== */
a{
    display: inline-block;
    margin: 20px;
    padding: 14px 34px;
    border-radius: 35px;
    font-size: 18px;
    font-weight: bold;
    text-decoration: none;
    color: #f97316;
    background: linear-gradient(135deg,#fff7ed,#ffedd5);
    border: 2px solid #fde047;
    transition: all 0.3s ease;
}

/* ===== Link Hover ===== */
a:hover{
    color: white;
    background: linear-gradient(135deg,#f97316,#fb7185);
    box-shadow: 0 14px 30px rgba(249,115,22,0.55);
    transform: translateY(-3px);
}

/* ===== Mobile Responsive ===== */
@media(max-width:768px){
    .U{
        width: 92%;
        padding: 35px;
    }
    input[type="text"],
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
 
  out.print("<CENtEr>");out.print("<form class='U' action='UserProfile1' method='post'>");
 while(F.next())
 {out.print("<DIV Style='Color:Blue;'>"); out.println("Full Name<P Style='diSplay:inline;Margin-left:267px;'>Email</P><BR><input type='text' Class='Font' Size='30' value=\""+F.getString(1)+"\" name='Name'></input><P Style='diSplay:inline;Margin-left:10px;'><input type='text' Class='Font' value="+F.getString(3)+" name='Email'></input></P><BR>");
 out.println("<BR>Mobile Number<P Style='diSplay:inline;Margin-left:239px;'>Class</P><BR><input type='text' class='Font'  value="+F.getString(7)+" name='M'></input><P Style='diSplay:inline;Margin-left:10px;'><input type='text' class='Font' value="+F.getString(5)+" name='A'></input></P><BR>");
 out.println("<BR>Address<BR>");
	
	

	
	
	
	out.print("<input type='text' class='Font' value="+F.getString(4)+" name='C'></input>");out.print("</DIV>");

	 String N=(String)request.getAttribute("N");
	    if(N!=null)
	    {
	    out.print(N);
	    }
		String E=(String)request.getAttribute("E");
	    if(E!=null)
	    {
	    out.print(E);
	    }
		
		String Erro=(String)request.getAttribute("Error");
	    if(Erro!=null)
	    {
	    out.print("<P Style='Color:red;'>"+Erro+"</P>");
	    }
		
		String A=(String)request.getAttribute("A");
	    if(A!=null)
	    {
	    out.print(A);
	    }
		
		String H=(String)request.getAttribute("F");
	    if(H!=null)
	    {
	    out.print(H);
	    }
		break;
		
 }
 out.print("<BR><BR>");
 out.print("<input type='SuBmit'  style='border:2px solid Blue;Background-Color:Yellow;margin-left:300px;height:21px;width:100px;'Value='Edit'>");
out.print("</form>");out.print("</CENtEr>");

 %>
 <a href="Frame.jsp" style="border:2px solid yellow;height:100;width:300;font-size:31px; Color:Orange;">Go to Main Page</a>
</body>
</html>