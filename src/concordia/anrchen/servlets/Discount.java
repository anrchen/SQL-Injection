package concordia.anrchen.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concordia.anrchen.models.Game;
import concordia.anrchen.models.GameCatalog;

/**
 * Servlet implementation class Discount
 */
@WebServlet("/Discount")
public class Discount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Game> game_results = new ArrayList <Game>();
		GameCatalog catalog = new GameCatalog();
		game_results = catalog.getDiscount();
		
		if(game_results.isEmpty()){
			request.getSession().setAttribute("error_message", "No discount found");
			response.sendRedirect("welcome.jsp");
		} else{
			request.setAttribute("game_results", game_results);
			request.getSession().setAttribute("game_results", game_results);
			response.sendRedirect("searchResult.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
