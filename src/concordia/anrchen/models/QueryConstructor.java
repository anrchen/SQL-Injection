package concordia.anrchen.models;

public class QueryConstructor {
	public String getQuery(String name, String num_players, String coop, String console, String release_date, String genre, String publisher){
		if(name.isEmpty()){
			name = " game_name IS NOT NULL";
		} else{
			name = " game_name LIKE '%"+name+"%'";
		}
		if(num_players.isEmpty()){
			num_players = " num_players IS NOT NULL";
		} else{
			num_players = " num_players='"+num_players+"'";
		}
		if(coop.isEmpty()){
			coop = " coop IS NOT NULL";
		} else{
			coop = " coop='"+coop+"'";
		}
		if(console.isEmpty()){
			console = " console IS NOT NULL";
		} else{
			console = "  console LIKE '%"+console+"%'";
		}
		if(release_date.isEmpty()){
			release_date = " release_date IS NOT NULL";
		} else{
			release_date = " release_date LIKE '%"+release_date+"%'";
		}
		if(genre.isEmpty()){
			genre = " genre IS NOT NULL";
		} else{
			genre = " genre LIKE '%"+genre+"%'";
		}
		if(publisher.isEmpty()){
			publisher = " publisher IS NOT NULL";
		} else{
			publisher = " publisher LIKE '%"+publisher+"%'";
		}
		String query = "SELECT * FROM Game WHERE"+name+" AND"+num_players+" AND"+coop
				+" AND"+console+" AND"+release_date+" AND"+genre+" AND"+publisher;
		return query;
	}
}
