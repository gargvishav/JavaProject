package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection15
{
	public static Connection doconnect()
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence_management","root","Vishav16");
		}
		catch (ClassNotFoundException e) 
		{
						e.printStackTrace();
		}
		catch (SQLException e) 
		{
						e.printStackTrace();
		}
		return con;	
	}
	public static void main(String []args)
	{
		doconnect();
	}

}

