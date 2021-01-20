package DBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlConnection {

	public static String Connection_string="jdbc:mysql://localhost:3306/notificationcenterdb";
	public static String UserName="Admin";
	public static String Password="Admin";
	
	public static Connection getConnection() 
	{
		
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connection_string+"?user="+UserName+"&password="+Password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
