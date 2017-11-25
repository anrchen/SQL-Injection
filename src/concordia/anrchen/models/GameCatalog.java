// GameCatalog Model

package concordia.anrchen.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GameCatalog {
	List <Game> catalog;
	
	public GameCatalog (){
		this.catalog = new ArrayList <Game>();
	}
	
	public GameCatalog (List <Game> catalog){
		this.catalog = catalog;
	}
	
	public Game getGame (String game_name){
		for (int i=0; i<catalog.size(); i++){
			if (catalog.get(i).getGame_name().equals(game_name)){
				return catalog.get(i);
			}
		}
		return null;
	}
	
	// Connect to the database and get a game catalog from user search criteria
	public List <Game> getGameCatalog (String query_str){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/soen387_a1","root","");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query_str);
			System.out.println("From getGameCatalog");
			System.out.println(query_str);
			while (result.next()){
				Game game = new Game(result.getString("game_name"), result.getString("game_description"), result.getString("console"), result.getInt("num_players"), result.getBoolean("coop"),
						result.getString("genre"), result.getString("release_date"), result.getString("developer"), result.getString("publisher"), result.getString("front_box_art"),
						result.getString("back_box_art"), result.getString("logo"), result.getString("developer_logo"), result.getInt("price"), result.getInt("discount"));
				catalog.add(game);
				System.out.println("GetGame_name");
				System.out.println(game.getGame_name());
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return catalog;
	}
	
	public List <Game> getDiscount (){
		String query_str = "SELECT * FROM Game WHERE discount<>'0' ORDER BY discount DESC";
		List <Game> aCatalog = new ArrayList <Game> ();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/soen387_a1","root","");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query_str);
			while (result.next()){
				Game game = new Game(result.getString("game_name"), result.getString("game_description"), result.getString("console"), result.getInt("num_players"), result.getBoolean("coop"),
						result.getString("genre"), result.getString("release_date"), result.getString("developer"), result.getString("publisher"), result.getString("front_box_art"),
						result.getString("back_box_art"), result.getString("logo"), result.getString("developer_logo"), result.getInt("price"), result.getInt("discount"));
				System.out.println(game.getGame_name());
				aCatalog.add(game);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return aCatalog;
	}
}
