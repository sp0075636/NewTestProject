package dao;
import java.sql.*;

public class DbConnection {

	public Connection getConnection() throws Exception
	{
		try{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:siva","scott","tiger");
	    return con;
			
		}
		catch(Exception e){ throw e; }
		
	}
}
