<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>.U{DISPlay:INlINe-BloCK;MArGIN-lEFt:31px;JuStiFy-Content:Space-ArOUND;}
.Imgf {margIN:0 10Px;
	border: 4px solid Yellow;
	DISPlay:flex;flex-Direction:Column;
	Align-ItemS:Center;Height:fit-ConteNt;
	width: fit-CoNtent;
	DiSplay: Inline-Block;
	
	text-AligN: Center;
	
	margin-right: auto;
	
	border-bottom: 7px solid Blue;
}.R{height:200;WiDth:300px;DiSplaY:BloCK;margin:0 auto;}
.I{margin-left:100px;}
body {OVErflow-x:Scroll;
	background-image: url("data-sciences.jpg");
	Background-Attachment: fixed;
}
</style>
<title>Insert title here</title>
</head>
<body>


		<button onclick="extendSecondFrame()">
		<H1 ><--</H1></button>
		<script>
		function extendSecondFrame(){
			var frame=parent.document.getElementsByTagName('frameset')[0];
			if(frame){frame.cols="0%,*";}
			
		}</script>
		
		
		<button onclick="F()">
		<H1 >--></H1></button>
		<script>
		function F(){
			var frame=parent.document.getElementsByTagName('frameset')[0];
			if(frame){frame.cols="21%,*";}
			
		}</script><BR><BR><P Style="BaCKGRound-Color:OraNge;Height:31px;Color:White;"><A  Style="Background-Color:Orange;Height:31px;Border:NoNe;text-DeCoration:NoNe;font-SiZe:21px;Color:White;" href="Program.html">Programming language Courses</A><A  Style="Background-Color:Orange;Height:31px;text-DeCoration:NoNe;Border:NoNe;font-SiZe:21px;Color:White; MargIN-left:21px;" href="General.html">General Knowledge Courses</A></P>


<BR>
<div ClASS="U"><div class="Imgf"><a  href="JavaCourSe.html" class="imgf" ><img  ClASS="R" src="JSP.jpg" Style="Height:294px;" ></a><BR>
<H1 Style="MARGin-left:0px;Color:ORANGe;">JSP Fundamental</H1><H1 ClASS="I" style="border:2px solid yellow;height:37;width:100px;Color:white;text-align:Center;">Start</H1></div>

<div clasS="Imgf"><a  href="DotNetCore.html" ><img ClASS="R"  Style="Height:294px;" src="Dot.jpg" ></a></BR>

<H1 Style="MARGin-left:0px;Color:ORANGe;">Dot Net Core</H1><H1 ClASS="I" style="border:2px solid yellow;height:37;width:100px;Color:white;text-align:Center;">Start</H1></DIV>

<div clasS="Imgf"><a  href="ConSti.html" ><img ClASS="R" src="Const.jpg" Style=" Height:294px;" ></a></BR>

<H1 Style="MARGin-left:0px;Color:ORANGe;">Indian ConStitution</H1><H1 ClASS="I" style="border:2px solid yellow;height:37;width:100px;Color:white;text-align:Center;">Start</H1></Div>

<div clasS="Imgf"><a  href="Python.html" ><img ClASS="R" src="Python.jpg" Style=" Height:294px;" ></a></BR>

<H1 Style="MARGin-left:0px;Color:ORANGe;"> Python</H1><H1 ClASS="I" style="border:2px solid yellow;height:37;width:100px;Color:white;text-align:Center;">Start</H1></DIV>
<div clasS="Imgf"><a  href="Data.html" ><img ClASS="R" src="Copilot_20251122_174444.png" Style=" Height:294px;" ></a></BR>

<H1 Style="MARGin-left:0px;Color:ORANGe;"> Database Management <BR>System</H1><H1 ClASS="I" style="border:2px solid yellow;height:37;width:100px;Color:white;text-align:Center;">Start</H1></DIV></Div>


</body>
</html>