package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.CategoryDAO;
import coding.mentor.dao.RoomDAO;
import coding.mentor.dao.SubcategoryDAO;
import coding.mentor.entity.Category;
import coding.mentor.entity.Room;
import coding.mentor.entity.Subcategory;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();
	SubcategoryDAO subcategoryDAO = new SubcategoryDAO();
	RoomDAO roomDAO = new RoomDAO();

//	BookDAO bookDAO = new BookDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Category>  categories = categoryDAO.getAllShowedCategory();
			List<Subcategory>  subcategories = null;
			List<Room> rooms = roomDAO.getAllRoom();
			//attach Data to request
			request.setAttribute("categories", categories);
			request.setAttribute("rooms", rooms);
			
			String categoryId =  request.getParameter("categoryId");
			//System.out.println(categoryId + "heyyy/n");
			
			
			
			if (categoryId != null) {
			subcategories = subcategoryDAO.getSubcategoryById(Long.parseLong(categoryId));
			//attach Data to request
			request.setAttribute("subcategories", subcategories);
			}
//			List <Book> books = null;
			//get book details
			
			// get books by category
			
			// you are clicking a category
//			if (categoryId != null) {
//				books = bookDAO.getBooksByCategory(Long.parseLong(categoryId));
//				request.setAttribute("books", books);
//
//			// you are clicking a book
//			} else if (bookId != null) {
//				Book book = bookDAO.getBook(Integer.parseInt(bookId));			
//				request.setAttribute("book", book);
//
//			// you are clicking nothing (By Default)
//			} else {
//				books = bookDAO.getAllBooks();
//				request.setAttribute("books", books);
//			}
//			

			//send Data to JSP
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			
			rd.forward(request, response);
			//response.sendRedirect("home.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
