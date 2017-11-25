// RegistrationBean Model

package concordia.anrchen.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationBean {
	private String username;
	private String psw;
	private String firstname;
	private String lastname;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String credit_card_type;
	private String credit_card_number;
	private String credit_card_cvv;
	private String credit_card_expiry;
	private String date_str;
	
	public RegistrationBean (String username, String psw, String firstname, String lastname, String address1, String address2, 
			String city, String state, String zip, String country, String credit_card_type, String credit_card_number, 
			String credit_card_cvv, String credit_card_expiry){
		this.username = username;
		this.psw = psw;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.credit_card_cvv = credit_card_cvv;
		this.credit_card_expiry = credit_card_expiry;
		this.credit_card_number = credit_card_number;
		this.credit_card_type = credit_card_type;
	}
	
	public int storeUser (){
		int result = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.date_str = dateFormat.format(date);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/soen387_a1","root","");
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO User (password, firstname, lastname, email, address1, address2, city, state, "
					+ "zip, country, credit_card_type, credit_card_number, credit_card_cvv, credit_card_expiry, last_login) "
					+ "VALUES ("
					+ "'"+psw+"',"
					+ "'"+firstname+"',"
					+ "'"+lastname+"',"
					+ "'"+username+"',"
					+ "'"+address1+"',"
					+ "'"+address2+"',"
					+ "'"+city+"',"
					+ "'"+state+"',"
					+ "'"+zip+"',"
					+ "'"+country+"',"
					+ "'"+credit_card_type+"',"
					+ "'"+credit_card_number+"',"
					+ "'"+credit_card_cvv+"',"
					+ "'"+credit_card_expiry+"',"
					+ "'"+date_str
					+"')";
			result = statement.executeUpdate(sql);
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
}
