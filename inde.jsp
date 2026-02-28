<!DOCTYPE html>
<html>
<head>
<style>

@media(max-width:600px)
{
    .U
{
	border:4px solid lightblue;
	height:500px;
	width:470px;
	margin-left:310px;
	border-radius:300px;
	border-shadow:21px gray;
	background-color:lightblue;
	border-color:orange;
	padding-left:134px;

	margin-top:0px;
	
}
.F
{
    border-radius:34px;
    border-color:blue;
    height:29px;
    width:310px;
}
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
body
{
	background-image:url("library.jpg");
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
    
}
@media(min-width:600px)
{
    .U
{
	border:4px solid lightblue;
	height:410px;
	width:470px;
	margin-left:310px;
	background-color:lightblue;
	border-radius:100px;
	border-shadow:21px gray;
	border-color:orange;
	padding-left:134px;
	
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
        font-size:31px;
        text-Shadow:3px 2px 4px grey;
        font-family:Hevetica Neue;
        font-style:italic;
        letter-spacing:0.1em;
        }
        .I:hover
        {color:Blue;text-Shadow:3px 2px 4px grey;
        
        }
    

/* 1. Base Styles for the Box */
.modal-Box {
    /* Initially hide the box */
    display: none; 

    /* Positioning and Centering */
    
} header {
            background-color: #2C3E50;
            color: white;
            padding: 15px 0;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
        }
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1100px;
            margin: 0 auto;
            padding: 0 20px;
        }
        .logo {
            font-size: 1.8em;
            font-weight: bold;
            color: white;
            text-decoration: none;
            
            height:141px;width:103px;
        }
        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        nav ul li {
            margin-left: 25px;
        }
        nav ul li a {
            color: white;
            font-weight: 500;
            padding: 5px 0;
            position: relative;
        }
        nav ul li a::after {
            content: '';
            position: absolute;
            width: 0;
            height: 2px;
            background-color: #3498DB;
            left: 0;
            bottom: -5px;
            transition: width 0.3s ease-in-out;
        }
        nav ul li a:hover::after {
            width: 100%;
        }
        .nav-button {
            background-color: #E74C3C;
            padding: 8px 18px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .nav-button:hover {
            background-color: #C0392B;
        }


/* 2. Styles for the actual content inside the box */
.login-Content {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
    width: 350px; /* Adjust size as needed */
    max-width: 40%;
}

/* Removes default list bullet points and padding */
.main-menu {
  list-style-type: none; /* Removes the bullet points */
  margin: 0;
  padding: 0;
  overflow: hidden; /* Contains the floated list items */
  background-color: lightBlue; /* Dark background for the navigation bar */
}

/* Styles the individual menu items */
.main-menu li {
  float: left; /* Makes the list items appear side-by-side (horizontal layout) */
}

/* Styles the links inside the menu items */
.main-menu li a {
  display: block; /* Makes the entire <li> area clickable */
  color: white; /* Text color */
  text-align: center;
  padding: 14px 16px; /* Spacing around the text */
  text-decoration: none; /* Removes the default underline from links */
}

/* Change the background color on hover */
.main-menu li a:hover {
  background-color: #555;
}
/* 3. The class to make the box visible */
.modal-Box.show {
    /* Override 'display: none' when the 'show' class is added by JavaScript */
    display: flex;
}

/* Optional: Basic form styling for better look */
.login-Content input, .login-Content button {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
}body{background-image:url("data-sciences.jpg");
height: 100vh; /* Set the height of the viewport */
    overflow-y: scroll;
     height: 100vh; /* Set the height of the viewport */
    overflow-y: scroll;}
    /* Apply this to the main <body> or a specific container <div> */

/* If you want only the login box to scroll (less common for a login form) */
.login-Container {
    height: 400px; /* Fixed height is required */
    overflow-y: auto; /* Enable scroll only if content overflows */
}
/* For WebKit browsers (Chrome, Safari) */
body::-webkit-scrollbar {
    display: none; /* Hides the scrollbar */
}
}
</style>
<meta charset="ISO-8859-1">
<title>User login</title>
<link rel="stylesheet" href="Styles.css">
</head>
<body>




<header>
        <nav>
            <img src="logoCheck.jpg" class="logo"></a><H1 Class="I">Knowledge Check Demonstration</H1>
            <ul>
              
                <li><a href="services.html">Services</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="contact.html" class="nav-button">Contact</a></li>
            </ul>
        </nav>
    </header><Center><h1  Style="Color:Orange;text-Decoration:Dotted;">First, you Need to log in here</h1></Center>

    
<form action="Validate" class="U Y" method="post">
<Center><H1><U style="color:rgb(255,255,155);padding-right:130px;text-shadow:3px 2px 2px gray;font-size:31px;">User login</U></H1></Center>


 <label style="color:rgb(255,14,154);font-size:21px;">Enter Email Id </label><BR><input type="text" name="Name" class="F" autocomplete="username">
  <BR><div class="Error">
    <%
    
    String Error=(String)request.getAttribute("Error");
    if(Error!=null)
    {
    out.print(Error);
    }
    %></div>
  <BR>
 <DIV><label style="color:rgb(255,14,154);font-size:21px;">Enter Password</label><BR><input type="Password" id="F" name="Password"   class="F" autocomplete="current-password">
  <span  Id="u" onclick="togglePasswordVisibility()">&#128065;</span></DIV>
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
  
  <B>Don't have an Account?Please <a href="Register.jsp" Style="text-Decoration:None;Background-Color:lightBlue;height:31px;width:41px;">Register</a></B>
   <div class="Error">
    <%
    
    String Invalid=(String)request.getAttribute("Invalid");
    if(Invalid!=null)
    {
    out.print(Invalid);
    }
    %></div><BR>
  <div>
 
    

 </div>
 
</form>
 
<Script>function togglePasswordVisibility() {
	  const passwordInput = document.getElementById('F');
	  
	  
	  if (passwordInput.type === 'password') {
	    passwordInput.type = 'text';
	 
	    document.getElementById('u').innerHTML='&#128584;'
	    // Optional: Change icon to a 'hidden' symbol
	  } else {
	    passwordInput.type = 'password';
	    document.getElementById('u').innerHTML='&#128065;'
	    // Change icon back to the 'visible' symbol
	  }
	}</Script>

</body>
</html>