package User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conec.Serv;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int u=0,v=0,M=0;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Q1=request.getParameter("Q1");
		if(Q1==null||Q1.trim().isEmpty())
		{
			v=v+1;
			
		}
		else if(Q1.equals("Servlet"))
		{
		
			u++;
		}
		else if(!Q1.equals("Servlet"))
		{
		
			M++;
		}
		String Q2=request.getParameter("Q2");
		if(Q2==null||Q2.trim().isEmpty())
		{
		
			v=v+1;
		}
		else if("<%@include file=..%>".equals("<%@include file=..%>")){
			u++;
		}
		else if(!"<%@include file=..%>".equals("<%@include file=..%>")){
			M++;
		}
		String Q3=request.getParameter("Q3");
		if(Q3==null||Q3.trim().isEmpty())
		{v=v+1;
		}
		else if(Q3.equals("jspInit()")){
			u=u+1;
		}
		else if(!Q3.equals("jspInit()")){
			M++;
		}
		String Q4=request.getParameter("Q4");
		if(Q4==null||Q4.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q4.equals("session")){
			u=u+1;
		}
		else if(!Q4.equals("session")){
			M++;
		}
		String Q5=request.getParameter("Q5");
		if(Q5==null||Q5.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q5.equals("<%=expression %>")){
			u=u+1;
		}
		
		else if(!Q5.equals("<%=expression %>")){
			M++;
		}
		String Q6=request.getParameter("Q6");
		if(Q6==null||Q6.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q6.equals("Scriptlet(<%..%>)")){
			u=u+1;
		}
		else if(!Q6.equals("Scriptlet(<%..%>)")){
			M++;
		}
		String Q7=request.getParameter("Q7");
		if(Q7==null||Q7.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q7.equals("application scope")){
			u=u+1;
		}
		else if(!Q7.equals("application scope")){
			M++;
		}
		String Q8=request.getParameter("Q8");
		if(Q8==null||Q8.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q8.equals("To Specify that this page will handle and display errors from other JSP")){
			u=u+1;
		}
		else if(!Q8.equals("To Specify that this page will handle and display errors from other JSP")){
		M=M+1;
		}
		String Q9=request.getParameter("Q9");
		if(Q9==null||Q9.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q9.equals("out")){
			u=u+1;
		}
		
		else if(!Q9.equals("out")){
			M=M+1;
		}
		String Q10=request.getParameter("Q10");
		if(Q10==null||Q10.trim().isEmpty())
		{
			v=v+1;
		
		}
		else if(Q10.equals("pageContext")){
			u=u+1;
		}else if(!Q10.equals("pageContext")) {M=M+1;}
		
		if(u>=8)
		{
			RequestDispatcher R=request.getRequestDispatcher("Congrat.jsp");
			R.forward(request,response);
			LocalDate data=LocalDate.now();
			DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyy");
			String dateString=data.format(form);
			ServletContext session=request.getServletContext();
			session.setAttribute("time",dateString);
			
		}
		else {
			
			
			HttpSession session=request.getSession();
			session.setAttribute("Mark", v);
			
			session.setAttribute("MarkGet",u);
			session.setAttribute("Get",M);
			
			RequestDispatcher R=request.getRequestDispatcher("Again1.jsp");
			R.forward(request, response);

					}
		
		try
		{
			Connection R=Serv.get();
			CallableStatement U=R.prepareCall("{call Cour(?,?,?,?)}");
			U.setInt(1, 1);
			U.setString(2, "JSP Fundamental");
			U.setInt(3,u);
			ServletContext application=getServletContext();
			String user=(String)application.getAttribute("U");
			U.setString(4, user);
			U.execute();
			
			CallableStatement F=R.prepareCall("{call Data(?,?,?)}");
			F.setString(1, user);
			PreparedStatement P=R.prepareStatement("Select * from userData Where name=?");
			P.setString(1, user);
			ResultSet email=P.executeQuery();
			while(email.next())
			{if(user.equals(email.getString(1)))
			{
			F.setString(2, email.getString(3));}}
			F.setInt(3, u);
			F.execute();
		}catch(Exception U) {}
		ServletContext application = getServletContext();
	    // Store a value in application scope
	    application.setAttribute("A", "JSP Fundamental");

		
	}

	

}
