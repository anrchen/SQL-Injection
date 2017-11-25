// Login Servlet/Controller

package concordia.anrchen.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import concordia.anrchen.models.LoginBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		HttpSession session = request.getSession();
		
		LoginBean login = new LoginBean(username, psw);
		Boolean auth = login.authenticate();
		
		// Check for username and password
		if(auth){
			login.updateLastLogin();
			session.setAttribute("username", username);
			session.setAttribute("error_message", null);
			response.sendRedirect("welcome.jsp");
		} else{
			response.sendRedirect("login.jsp");
			String error_message = "Wrong username or password<br></br>";
			session.setAttribute("error_message", error_message);
		}
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
