// Game Model

package concordia.anrchen.models;

public class Game {
	String game_name;
	String game_description;
	String console;
	int num_players;
	boolean coop;
	String genre;
	String release_date;
	String developer;
	String publisher;
	String front_box_art;
	String back_box_art;
	String logo;
	String developer_logo;
	int price;
	int discount;
	
	public Game(String game_name, String game_description, String console, int num_players, boolean coop,
			String genre, String release_date, String developer, String publisher, String front_box_art,
			String back_box_art, String logo, String developer_logo, int price, int discount) {
		this.game_name = game_name;
		this.game_description = game_description;
		this.console = console;
		this.num_players = num_players;
		this.coop = coop;
		this.genre = genre;
		this.release_date = release_date;
		this.developer = developer;
		this.publisher = publisher;
		this.front_box_art = front_box_art;
		this.back_box_art = back_box_art;
		this.logo = logo;
		this.developer_logo = developer_logo;
		this.price = price;
		this.discount = discount;
	}

	/**
	 * @return the game_name
	 */
	public String getGame_name() {
		return game_name;
	}

	/**
	 * @param game_name the game_name to set
	 */
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	/**
	 * @return the game_description
	 */
	public String getGame_description() {
		return game_description;
	}

	/**
	 * @param game_description the game_description to set
	 */
	public void setGame_description(String game_description) {
		this.game_description = game_description;
	}

	/**
	 * @return the console
	 */
	public String getConsole() {
		return console;
	}

	/**
	 * @param console the console to set
	 */
	public void setConsole(String console) {
		this.console = console;
	}

	/**
	 * @return the num_players
	 */
	public int getNum_players() {
		return num_players;
	}

	/**
	 * @param num_players the num_players to set
	 */
	public void setNum_players(int num_players) {
		this.num_players = num_players;
	}

	/**
	 * @return the coop
	 */
	public boolean isCoop() {
		return coop;
	}

	/**
	 * @param coop the coop to set
	 */
	public void setCoop(boolean coop) {
		this.coop = coop;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the release_date
	 */
	public String getRelease_date() {
		return release_date;
	}

	/**
	 * @param release_date the release_date to set
	 */
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}

	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the front_box_art
	 */
	public String getFront_box_art() {
		return front_box_art;
	}

	/**
	 * @param front_box_art the front_box_art to set
	 */
	public void setFront_box_art(String front_box_art) {
		this.front_box_art = front_box_art;
	}

	/**
	 * @return the back_box_art
	 */
	public String getBack_box_art() {
		return back_box_art;
	}

	/**
	 * @param back_box_art the back_box_art to set
	 */
	public void setBack_box_art(String back_box_art) {
		this.back_box_art = back_box_art;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the developer_logo
	 */
	public String getDeveloper_logo() {
		return developer_logo;
	}

	/**
	 * @param developer_logo the developer_logo to set
	 */
	public void setDeveloper_logo(String developer_logo) {
		this.developer_logo = developer_logo;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public boolean equals(Game aGame){
		if(aGame.getGame_name().equals(this.getGame_name())){
			return true;
		} else{
			return false;
		}
	}
}
