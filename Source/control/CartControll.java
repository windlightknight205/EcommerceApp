package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import entity.Category;
import entity.Item;
import entity.Product;


@WebServlet("/cart")
public class CartControll extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Object respone;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			} 
			else if(action.equalsIgnoreCase("buynow")) {
				doGet_BuyNow(request, response);
			}
			else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
			else if(action.equalsIgnoreCase("add")) {
				doGet_Add(request, response);
			}
			else if(action.equalsIgnoreCase("minus")) {
				doGet_Minus(request, response);
			}
		}
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}
	protected void doGet_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(request.getParameter("id"), cart);
		int quantity = cart.get(index).getQuantity() + 1;
		cart.get(index).setQuantity(quantity);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}
	protected void doGet_Minus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(request.getParameter("id"), cart);
		int quantity = cart.get(index).getQuantity() - 1;
		cart.get(index).setQuantity(quantity);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(request.getParameter("id"), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			DAO dao = new DAO();
			String id = request.getParameter("id");
			Product p= dao.getProductById(id);
			cart.add(new Item(p, 1));
			session.setAttribute("cart", cart);
			
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExisting(request.getParameter("id"), cart);
			if (index == -1) {
				String id = request.getParameter("id");
				DAO dao = new DAO();
				Product p= dao.getProductById(id);
				cart.add(new Item(p, 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("Home");
	}
	protected void doGet_BuyNow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			DAO dao = new DAO();
			String id = request.getParameter("id");
			Product p= dao.getProductById(id);
			cart.add(new Item(p, 1));
			session.setAttribute("cart", cart);
			
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExisting(request.getParameter("id"), cart);
			if (index == -1) {
				String id = request.getParameter("id");
				DAO dao = new DAO();
				Product p= dao.getProductById(id);
				cart.add(new Item(p, 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("cart");
	}
	private int isExisting(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
				return i;			}
		}
		return  -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
