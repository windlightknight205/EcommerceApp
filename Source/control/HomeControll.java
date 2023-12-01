package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeControll extends HttpServlet {

	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		// get data tu DAO
		DAO dao = new DAO();
		List<Product> list = dao.Paging(1);
		List<Category> listC= dao.getAllCategory();
		Product last=dao.getLast();
		int pc= dao.Page_Count();
		// set data len jsp
		request.setAttribute("listP", list);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
		request.setAttribute("pc", pc);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProcessRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProcessRequest(request, response);
	}
}
