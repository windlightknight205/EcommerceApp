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
 * Servlet implementation class PagingControll
 */
@WebServlet("/paging")
public class PagingControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("paging")) {
			doGet_Page(request, response);
		} else if (action.equalsIgnoreCase("previous")) {
			doGet_Previous(request, response);
		} else if (action.equalsIgnoreCase("next")) {
			doGet_Next(request, response);
		}
	}

	protected void doGet_Page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		int index = Integer.parseInt(request.getParameter("index"));
		List<Product> list = dao.Paging(index);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		int pc = dao.Page_Count();
		// set data len jsp
		request.setAttribute("listP", list);
		request.setAttribute("listC", listC);
		request.setAttribute("p", last);
		request.setAttribute("page", index);
		request.setAttribute("pc", pc);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet_Previous(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		int index = Integer.parseInt(request.getParameter("index"));
		if (index >= 1) {
			List<Product> list = dao.Paging(index);
			List<Category> listC = dao.getAllCategory();
			Product last = dao.getLast();
			int pc = dao.Page_Count();
			// set data len jsp
			request.setAttribute("listP", list);
			request.setAttribute("listC", listC);
			request.setAttribute("p", last);
			request.setAttribute("page", index);
			request.setAttribute("pc", pc);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("Home");
		}
	}

	protected void doGet_Next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		int index = Integer.parseInt(request.getParameter("index"));
		int pc = dao.Page_Count();
		if (index <= pc) {
			List<Product> list = dao.Paging(index);
			List<Category> listC = dao.getAllCategory();
			Product last = dao.getLast();
			// set data len jsp
			request.setAttribute("listP", list);
			request.setAttribute("listC", listC);
			request.setAttribute("p", last);
			request.setAttribute("page", index);
			request.setAttribute("pc", pc);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("Home");
		}
	}

}
