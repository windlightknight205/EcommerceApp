package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import entity.Account;

/**
 * Servlet implementation class SignupControll
 */
@WebServlet("/signup")
public class SignupControll extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF=8");
		String username = request.getParameter("suser");
		String password = request.getParameter("spass");
		String repassword=request.getParameter("srepass");
		if(password==repassword) {
			response.sendRedirect("Login.jsp");
		}
		else {
			DAO dao= new DAO();
			Account a=dao.Checkaccount(username);
			if(a==null) {
				dao.Signup(username, password);
				response.sendRedirect("Home");
			}
			else {
				response.sendRedirect("Login.jsp");
			}
		}
	
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}


}
