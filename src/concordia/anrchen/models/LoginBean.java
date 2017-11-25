package concordia.anrchen.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginBean {
	private String username;
	private String psw;
	
	public LoginBean (String username, String psw){
		this.username = username;
		this.psw = psw;
	}
	
	public boolean authenticate (){
		boolean auth = false;
		try{
			// To solve the ClassNotFound exception
			// 1) add mysql-connector to build path
			// 2) add mysql-connector to TomCat lib folder
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/soen387_a1","root","");
			Statement statement = connection.createStatement();
			String sql = "SELECT user_id FROM User WHERE email ='"+username+"' and password ='"+psw+"'";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
				auth = true;
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return auth;
	}
	
	public void updateLastLogin(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date_str = dateFormat.format(date);
		String sql = "UPDATE User SET last_login='"+date_str+"' WHERE email='"+username+"'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/soen387_a1","root","");
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
