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
@WebServlet("/Check5")
public class Check5 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int u=0,v=0,M=0;
		String Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18,Q19,Q20,Q21,Q22,Q23,Q24,Q25,Q26,Q27,Q28,Q29,Q30,Q31,Q32,Q33,Q34,Q35,Q36,Q37,Q38,Q39,Q40;

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// Initialize counters before processing
	

		// Q1
		Q1 = request.getParameter("Q1");
		if(Q1==null || Q1.trim().isEmpty()) { v++; }
		else if(Q1.equals("Servlet")) { u++; } else { M++; }

		// Q2
		Q2 = request.getParameter("Q2");
		if(Q2==null || Q2.trim().isEmpty()) { v++; }
		else if(Q2.equals("DROP")) { u++; } else { M++; }

		// Q3
		Q3 = request.getParameter("Q3");
		if(Q3==null || Q3.trim().isEmpty()) { v++; }
		else if(Q3.equals("INSERT")) { u++; } else { M++; }

		// Q4
		Q4 = request.getParameter("Q4");
		if(Q4==null || Q4.trim().isEmpty()) { v++; }
		else if(Q4.equals("ACID")) { u++; } else { M++; }

		// Q5
		Q5 = request.getParameter("Q5");
		if(Q5==null || Q5.trim().isEmpty()) { v++; }
		else if(Q5.equals("3NF")) { u++; } else { M++; }

		// Q6
		Q6 = request.getParameter("Q6");
		if(Q6==null || Q6.trim().isEmpty()) { v++; }
		else if(Q6.equals("Circular")==false) { u++; } else { M++; }

		// Q7
		Q7 = request.getParameter("Q7");
		if(Q7==null || Q7.trim().isEmpty()) { v++; }
		else if(Q7.equals("WHERE")) { u++; } else { M++; }

		// Q8
		Q8 = request.getParameter("Q8");
		if(Q8==null || Q8.trim().isEmpty()) { v++; }
		else if(Q8.equals("Index")) { u++; } else { M++; }

		// Q9
		Q9 = request.getParameter("Q9");
		if(Q9==null || Q9.trim().isEmpty()) { v++; }
		else if(Q9.equals("Referential Integrity")) { u++; } else { M++; }

		// Q10
		Q10 = request.getParameter("Q10");
		if(Q10==null || Q10.trim().isEmpty()) { v++; }
		else if(Q10.equals("JOIN")) { u++; } else { M++; }

		// Q11
		Q11 = request.getParameter("Q11");
		if(Q11==null || Q11.trim().isEmpty()) { v++; }
		else if(Q11.equals("TRUNCATE")) { u++; } else { M++; }

		// Q12
		Q12 = request.getParameter("Q12");
		if(Q12==null || Q12.trim().isEmpty()) { v++; }
		else if(Q12.equals("GRANT")) { u++; } else { M++; }

		// Q13
		Q13 = request.getParameter("Q13");
		if(Q13==null || Q13.trim().isEmpty()) { v++; }
		else if(Q13.equals("COMMIT")) { u++; } else { M++; }

		// Q14
		Q14 = request.getParameter("Q14");
		if(Q14==null || Q14.trim().isEmpty()) { v++; }
		else if(Q14.equals("Foreign Key")) { u++; } else { M++; }

		// Q15
		Q15 = request.getParameter("Q15");
		if(Q15==null || Q15.trim().isEmpty()) { v++; }
		else if(Q15.equals("GROUP BY")) { u++; } else { M++; }

		// Q16
		Q16 = request.getParameter("Q16");
		if(Q16==null || Q16.trim().isEmpty()) { v++; }
		else if(Q16.equals("Reliability")==false) { u++; } else { M++; }

		// Q17
		Q17 = request.getParameter("Q17");
		if(Q17==null || Q17.trim().isEmpty()) { v++; }
		else if(Q17.equals("DISTINCT")) { u++; } else { M++; }

		// Q18
		Q18 = request.getParameter("Q18");
		if(Q18==null || Q18.trim().isEmpty()) { v++; }
		else if(Q18.equals("DEFAULT")) { u++; } else { M++; }

		// Q19
		Q19 = request.getParameter("Q19");
		if(Q19==null || Q19.trim().isEmpty()) { v++; }
		else if(Q19.equals("VIEW")) { u++; } else { M++; }

		// Q20
		Q20 = request.getParameter("Q20");
		if(Q20==null || Q20.trim().isEmpty()) { v++; }
		else if(Q20.equals("Trigger")) { u++; } else { M++; }

		// Q21
		Q21 = request.getParameter("Q21");
		if(Q21==null || Q21.trim().isEmpty()) { v++; }
		else if(Q21.equals("ORDER BY")) { u++; } else { M++; }

		// Q22
		Q22 = request.getParameter("Q22");
		if(Q22==null || Q22.trim().isEmpty()) { v++; }
		else if(Q22.equals("NOT NULL")) { u++; } else { M++; }

		// Q23
		Q23 = request.getParameter("Q23");
		if(Q23==null || Q23.trim().isEmpty()) { v++; }
		else if(Q23.equals("ALTER")) { u++; } else { M++; }

		// Q24
		Q24 = request.getParameter("Q24");
		if(Q24==null || Q24.trim().isEmpty()) { v++; }
		else if(Q24.equals("CHECK")) { u++; } else { M++; }

		// Q25
		Q25 = request.getParameter("Q25");
		if(Q25==null || Q25.trim().isEmpty()) { v++; }
		else if(Q25.equals("UNION")) { u++; } else { M++; }

		// Q26
		Q26 = request.getParameter("Q26");
		if(Q26==null || Q26.trim().isEmpty()) { v++; }
		else if(Q26.equals("SAVEPOINT")) { u++; } else { M++; }

		// Q27
		Q27 = request.getParameter("Q27");
		if(Q27==null || Q27.trim().isEmpty()) { v++; }
		else if(Q27.equals("AS")) { u++; } else { M++; }

		// Q28
		Q28 = request.getParameter("Q28");
		if(Q28==null || Q28.trim().isEmpty()) { v++; }
		else if(Q28.equals("UNION")) { u++; } else { M++; }

		// Q29
		Q29 = request.getParameter("Q29");
		if(Q29==null || Q29.trim().isEmpty()) { v++; }
		else if(Q29.equals("COUNT")) { u++; } else { M++; }

		// Q30
		Q30 = request.getParameter("Q30");
		if(Q30==null || Q30.trim().isEmpty()) { v++; }
		else if(Q30.equals("MAX")) { u++; } else { M++; }

		// Q31
		Q31 = request.getParameter("Q31");
		if(Q31==null || Q31.trim().isEmpty()) { v++; }
		else if(Q31.equals("HAVING")) { u++; } else { M++; }

		// Q32
		Q32 = request.getParameter("Q32");
		if(Q32==null || Q32.trim().isEmpty()) { v++; }
		else if(Q32.equals("DROP DATABASE")) { u++; } else { M++; }

		// Q33
		Q33 = request.getParameter("Q33");
		if(Q33==null || Q33.trim().isEmpty()) { v++; }
		else if(Q33.equals("CREATE DATABASE")) { u++; } else { M++; }

		// Q34
		Q34 = request.getParameter("Q34");
		if(Q34==null || Q34.trim().isEmpty()) { v++; }
		else if(Q34.equals("UPDATE")) { u++; } else { M++; }

		// Q35
		Q35 = request.getParameter("Q35");
		if(Q35==null || Q35.trim().isEmpty()) { v++; }
		else if(Q35.equals("DELETE")) { u++; } else { M++; }

		// Q36
		Q36 = request.getParameter("Q36");
		if(Q36==null || Q36.trim().isEmpty()) { v++; }
		else if(Q36.equals("AVG")) { u++; } else { M++; }

		// Q37
		Q37 = request.getParameter("Q37");
		if(Q37==null || Q37.trim().isEmpty()) { v++; }
		else if(Q37.equals("TRUNCATE")) { u++; } else { M++; }

		// Q38
		Q38 = request.getParameter("Q38");
		if(Q38==null || Q38.trim().isEmpty()) { v++; }
		else if(Q38.equals("INSERT")) { u++; } else { M++; }

		// Q39
		Q39 = request.getParameter("Q39");
		if(Q39==null || Q39.trim().isEmpty()) { v++; }
		else if(Q39.equals("ALTER TABLE DROP COLUMN")) { u++; } else { M++; }

		// Q40
		Q40 = request.getParameter("Q40");
		if(Q40==null || Q40.trim().isEmpty()) { v++; }
		else if(Q40.equals("GRANT")) { u++; } else { M++; }

		// Finally, you can output results
		
		
		if(u>30)
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
			
			RequestDispatcher R=request.getRequestDispatcher("Again.jsp");
			R.forward(request, response);

					}
		
		try
		{
			Connection R=Serv.get();
			CallableStatement U=R.prepareCall("{call Cour(?,?,?,?)}");
			U.setInt(1, 5);
			U.setString(2, "DBMS");
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
	    application.setAttribute("A", "Database Management");

		
	}

	

}
