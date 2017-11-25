// Registration Servlet/Controller

package concordia.anrchen.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import concordia.anrchen.models.RegistrationBean;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String credit_card_type = request.getParameter("credit_card_type");
		String credit_card_number = request.getParameter("credit_card_number");
		String credit_card_cvv = request.getParameter("credit_card_cvv");
		String credit_card_expiry = request.getParameter("credit_card_expiry");

		HttpSession session = request.getSession();

		// Check for username and password
		RegistrationBean registration = new RegistrationBean(username, psw, firstname, lastname, address1, address2, 
				city, state, zip, country, credit_card_type, credit_card_number, credit_card_cvv, credit_card_expiry);
		int result = registration.storeUser();
		
		// Redirect to welcome/search page if user authentification was successful 
		if(result == 1){
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} else{
			// Redirect to registration page if user authentification was unsuccessful 
			response.sendRedirect("registration.jsp");
			String error_message = "Something went wrong<br></br>";
			session.setAttribute("error_message", error_message);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
