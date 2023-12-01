package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import DAO.DAO;
import entity.Account;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class AddProductControll
 */
@WebServlet("/add")
public class AddProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		// get data tu DAO
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String price =  request.getParameter("price");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String CateID = request.getParameter("category");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int uid = a.getUid();
		DAO dao = new DAO();
		dao.addProduct(name, image, price, title, description, CateID, uid);
		response.sendRedirect("manager");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

}
