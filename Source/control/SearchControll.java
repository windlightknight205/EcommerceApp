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
 * Servlet implementation class SearchControll
 */
@WebServlet("/search")
public class SearchControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		// get data tu DAO
		String txt= request.getParameter("txt");
		DAO dao = new DAO();
		List<Product> listS=dao.SearchProductByName(txt);
		List<Category> listC= dao.getAllCategory();
		Product last=dao.getLast();
		// set data len jsp
		request.setAttribute("txtSearch", txt);
		request.setAttribute("listP",listS);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
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
