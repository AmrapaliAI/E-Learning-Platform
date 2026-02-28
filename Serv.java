package Conec;

import java.sql.Connection;
import java.sql.DriverManager;

public class Serv {
	public static Connection get()throws Exception
    
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection D=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Amrapali");
		return(D);
	}


}
