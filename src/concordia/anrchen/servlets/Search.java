// Search Servlet/Controller

package concordia.anrchen.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import concordia.anrchen.models.Game;
import concordia.anrchen.models.GameCatalog;
import concordia.anrchen.models.QueryConstructor;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String num_players = request.getParameter("num_player");
		String coop = request.getParameter("coop");
		String console = request.getParameter("console");
		String release_date = request.getParameter("year");
		String genre = request.getParameter("genre");
		String publisher = request.getParameter("publisher");
		HttpSession session = request.getSession();
		
		QueryConstructor query = new QueryConstructor();
		GameCatalog catalog = new GameCatalog();
		String query_str = query.getQuery(name, num_players, coop, console, release_date, genre, publisher);
		List <Game> game_results = new ArrayList <Game>();
		game_results = catalog.getGameCatalog(query_str);
		
		// Display error message if no result was found
		if(game_results.isEmpty()){
			session.setAttribute("error_message", "No result found");
			response.sendRedirect("welcome.jsp");
		} else{
			request.setAttribute("game_results", game_results);
			session.setAttribute("game_results", game_results);
			response.sendRedirect("searchResult.jsp");
		}
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
