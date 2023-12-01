package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CategoryControll
 */
@WebServlet("/category")
public class CategoryControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		// get data tu DAO
		DAO dao = new DAO();
		String cateId= request.getParameter("cid");
		List<Product> list= dao.getAllProductByCid(cateId);
		List<Category> listC= dao.getAllCategory();
		Product last=dao.getLast();
		request.setAttribute("listC", listC);
		request.setAttribute("listP", list);
		request.setAttribute("p", last);
		request.setAttribute("tag", cateId);
		// set data len jsp
		request.getRequestDispatcher("Home.jsp").forward(request, response);
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
