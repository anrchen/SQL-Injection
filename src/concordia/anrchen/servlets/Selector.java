// Selector Servlet/Controller

package concordia.anrchen.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concordia.anrchen.models.Game;
import concordia.anrchen.models.GameCatalog;

/**
 * Servlet implementation class Selector
 */
@WebServlet("/Selector")
public class Selector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String game_name = request.getParameter("game_name");
		@SuppressWarnings("unchecked")
		List <Game> gameCatalog_list = (List<Game>) request.getSession().getAttribute("game_results");
		GameCatalog gameCatalog = new GameCatalog(gameCatalog_list);
		Game aGame = gameCatalog.getGame(game_name);
		request.getSession().setAttribute("aGame", aGame);
		response.sendRedirect("gameDetail.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
