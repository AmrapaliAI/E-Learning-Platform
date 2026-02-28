<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.U
{
	border:4px solid lightblue;
	height:490px;
	width:590px;
	margin-left:10px;
	background-color:White;
	border-radius:100px;
	border-shadow:21px gray;
	border-color:orange;
	
	PaDding:10px;
	margin-top:0px;
	
}body{background-image:url("data-sciences.jpg");}</style>
</head>
<body>
<Center class="U"><H1 style="color:Orange;">Try Again Later</H1>
<H2 style="Color:Orange;">You haven't Qualify Assessment.</H2>
<table Cellspacing="0px" Border="14px" Style="Border:13px lightBlue Dotted;">

<tr>
<th><B style="color:Blue;font-size:21px;">Your total Score</B></th>
<th><B style="color:Blue;font-size:21px;">Your total Wrong Answers</B></th>
<th><B style="color:Blue;font-size:21px;">You haven't Answered</B></th>
</tr>
<tr Style="text-align:Center;">
<td><B style="color:Orange;font-size:21px;"><%=session.getAttribute("MarkGet") %></B></td>

<td><B style="color:Orange;font-size:21px;"><%=session.getAttribute("Get") %></B></td>

<td><B style="color:Orange;font-size:21px;"><%=session.getAttribute("Mark") %></B></td>

</tr>
</table>
<BR><H1 style="Color:Green;font-Style:ItaliC;">Please answer at least 8 questions correctly.</H1>

<U style="Color:Orange;font-size:31px;"><a href="Frame.jsp" Style="text-decoration:None;">Go to Main Page</a></U></Center>
</body>
</html>