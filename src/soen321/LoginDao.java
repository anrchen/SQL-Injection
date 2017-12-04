package soen321;

//Author: Saif Mahabub from 387 assignment 1
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	
	public String authenticateUser(LoginBean loginBean)
	{
		// Temporary variables for user inputs
		String email = loginBean.getEmail();
		String password = loginBean.getPassword();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String emailDB = "";
		String passwordDB = "";
		
		try
		{
			con = DBConnection.createConnection(); // Creating connection
			statement = con.createStatement(); // Used to write queries
			resultSet = statement.executeQuery("select email,password from user"); // Fetching results from database
			
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
			emailDB = resultSet.getString("email"); //Fetch the values in database
			passwordDB = resultSet.getString("password");
			
				if(email.equals(emailDB) && password.equals(passwordDB))
				{
				return "SUCCESS";
				}
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; 	
	}	
}