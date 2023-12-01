package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import entity.Account;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ManagerProductControll
 */
@WebServlet("/manager")
public class ManagerProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		// get data tu DAO
		HttpSession session= request.getSession();
		Account a= (Account) session.getAttribute("acc");
		int id= a.getUid();
		System.out.println(id);
		DAO dao= new DAO();
		List<Product> list=dao.ProductBySellId (id);
		List<Category> listC=dao.getAllCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("listP", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		// set data len jsp
		
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

}
