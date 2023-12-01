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
import entity.Product;
import entity.Category;

/**
 * Servlet implementation class EditProductControll
 */
@WebServlet("/edit")
public class EditProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		DAO dao = new DAO();
		Product a=dao.getProductById(id);
		List<Category> listC=dao.getAllCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("p", a);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);	}

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
