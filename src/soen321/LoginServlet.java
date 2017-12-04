package soen321;

//Author: Saif Mahabub from 387 assignment 1
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retrieving the values entered by the user and keeping it in instance variables for later
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		LoginBean loginBean = new LoginBean(); // Creating login bean object
		
		//Setting the email and password through the loginBean object to get it later on
		loginBean.setEmail(email); 
		loginBean.setPassword(password);
		
		
		LoginDao loginDao = new LoginDao(); //Creating login data access object
		
		String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
		
		if(userValidate.equals("SUCCESS"))
		{
			session.setAttribute("email", email); // Using setAttribute so that we can get the key in future
			request.getRequestDispatcher("/Home.jsp").forward(request, response);//Sending control to the page
		}
		
		else
		{
			request.setAttribute("errMessage", userValidate); 
			request.getRequestDispatcher("/Login.jsp").forward(request, response);//forwarding the request
		}
	}
}
