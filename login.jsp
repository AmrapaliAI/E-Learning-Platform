<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head><style> .U
{
	border:4px solid lightblue;
	height:370px;
	width:470px;
	margin-left:310px;
	background-color:lightblue;
	border-radius:100px;
	border-shadow:21px gray;
	border-color:orange;
	padding-left:134px;
	padding-top:78px;
	margin-top:0px;
	
}
.F
{
    border-radius:34px;
    border-color:blue;
    height:29px;
    width:310px;
    transition: all 0.2s ease-in-out;
}
.F:active{ border-radius:34px;

    height:29px;
    width:310px;
    transform:translateY(1px);
    box-shadow:0px 0px 30px 4px rgba(0,123,255,0.13) inset;}
.F:focus{
outline:none;


box-shadow:0px 10px 21px rgba(0,123,255,0.7);
border-color:violet;}
.Error{
Color:red;
Font-Size:14px;
}
.M
{
	animation-name:Y;
	
}
@keyframes Y
{
0%
{opacity:0px;
margin-top:0px;
}
100%
{opacity:1px;
margin-top:104px;
}
}

.V
{ 
    margin-top:47px;text-transform:underline;
    width:143px;
    text-align:center;
    color:hotpink;
   
    border-bottom:4px solid hotpink;
    }
    div{display:inline-Block;
        }
        .I
        {color:HotPink;
        Border-Color:Yellow;
        Outline-Color:Violet;
        font-size:91px;
        text-Shadow:3px 2px 4px grey;
        font-family:Hevetica Neue;
        font-style:italic;
        letter-spacing:0.1em;
        }
        .I:hover
        {color:Blue;text-Shadow:3px 2px 4px grey;
        
        }
    
}</style>
<body>
<Center><H1><U style="color:rgb(255,255,155);text-shadow:3px 2px 2px gray;font-size:31px;"><a href="login.html">User login</a></U></H1></Center>



<form action="Validate" class="U Y" id="loginContainer">

 <label style="color:rgb(255,14,154);font-size:21px;">Enter Email Id </label><BR><input type="text" name="Name" class="F">
  <BR><div class="Error">
    <%
    
    String Error=(String)request.getAttribute("Error");
    if(Error!=null)
    {
    out.print(Error);
    }
    %></div>
  <BR>
 <label style="color:rgb(255,14,154);font-size:21px;">Enter Password</label><BR><input type="Password" name="Password" class="F">
  <BR>
  <div class="Error">
    <%
    
    String E=(String)request.getAttribute("E");
    if(E!=null)
    {
    out.print(E);
    }
    %></div>
  <BR><BR>
  <Button style="height:34px;width:316px;border-radius:34px;border-color:blue;"><label style="color:rgb(255,14,154);font-size:21px;">Login</label></Button>
  <BR>
  <div class="Error">
    <%
    
    String U=(String)request.getAttribute("U");
    if(U!=null)
    {
    out.print(U);
    }
    %></div><BR>
  
  <B>Don't have an Account?Please Register/Sign up</B><BR><B style="color:Blue;padding-left:107px;">Below</B><BR>
   <div class="Error">
    <%
    
    String Invalid=(String)request.getAttribute("Invalid");
    if(Invalid!=null)
    {
    out.print(Invalid);
    }
    %></div><BR>
  <div>
 
    

 <P style="Border:3px solid blue;height:21px;width:100px;color:White;text-align:Center;background-color:white;font-size:21px;"><a href="Register.jsp">Register</a></P>
</div>
  

</form>
</body>
</html>