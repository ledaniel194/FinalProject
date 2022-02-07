package coding.mentor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.StudentDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDAO studentDAO = new StudentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String command = request.getParameter("command");
		System.out.println(command);
		if (command == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		if (command.equals("logout")) {
			logout(request, response);
			return;
		}
		
		else {
			response.sendRedirect("login.jsp");
			return;
		}
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			session.removeAttribute("me");
			response.sendRedirect("HomeServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//go to DB coding_mentor -> table student -> select Student by username=email and password=password
		// if data available -> return 1 record (id, first_name, last_name, email, password)
		// Dao -> collect record from DB -> wrap them into Entity
		// Response to Home.jsp if success (or re-login if fail)
		
		try {
			Student student = studentDAO.getStudentByEmailAndPassword(username, password);
		
			if (student == null) {
				//login fail
				//System.out.println("cai nay null a nha");
				response.sendRedirect("LoginServlet");
			} else {
				//login success
				//System.out.println(student.toString());
				HttpSession session = request.getSession();
				session.setAttribute("me", student);
				session.setAttribute("cart", new CartDTO(new HashMap<>()));
				response.sendRedirect("HomeServlet");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
