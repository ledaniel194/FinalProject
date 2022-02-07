package coding.mentor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.constant.Constant;
import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.dao.RoomDAO;
import coding.mentor.entity.ProductDetail;
import coding.mentor.entity.Room;

/**
 * Servlet implementation class Product
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDetailDAO productDetailDAO = new ProductDetailDAO();
    RoomDAO roomDAO = new RoomDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<ProductDetail> productDetails = productDetailDAO.getAllProduct();
			request.setAttribute("productDetails", productDetails);
			List<Room> rooms = roomDAO.getAllRoom();
			request.setAttribute("rooms", rooms);
			String categoryId = request.getParameter("categoryId");
			String indexPage = request.getParameter("index");
			System.out.println(categoryId);
			if (indexPage == null) {
				indexPage = "1";
			}
			if (categoryId == null) {
				int count = productDetailDAO.getTotalProduct();
//				System.out.println(count+ "/n");
				int endPage = count/Constant.NUMBER_OF_PRODUCT_PER_PAGE;
				if (count%Constant.NUMBER_OF_PRODUCT_PER_PAGE != 0) {
					endPage ++;
				}
				//set final 
				request.setAttribute("endPage", endPage);
				//set current page
				int index = Integer.parseInt(indexPage);
				request.setAttribute("tag", index);
				Room room = new Room();
				room.setId(0);
				room.setName("All products");
				request.setAttribute("cateId", null);
				request.setAttribute("room", room);
				List <ProductDetail> productPerPage = productDetailDAO.pagingAllProduct(Integer.parseInt(indexPage));    
				request.setAttribute("product", productPerPage);
			}
			else 
			if (categoryId != null) {
				Room room = roomDAO.getRoomById(Integer.parseInt(categoryId));
				request.setAttribute("room", room);
				int count = productDetailDAO.getTotalProductByCategoryId(Integer.parseInt(categoryId));
//				System.out.println(count+ "/n");
				int endPage = count/Constant.NUMBER_OF_PRODUCT_PER_PAGE;
				if (count%Constant.NUMBER_OF_PRODUCT_PER_PAGE != 0) {
					endPage ++;
				}
				//set final 
				request.setAttribute("endPage", endPage);
				request.setAttribute("cateId", categoryId);
				
				//set current page
				int index = Integer.parseInt(indexPage);
				request.setAttribute("tag", index);
				List <ProductDetail> productPerPage = productDetailDAO.pagingProductByCategory(Integer.parseInt(indexPage), Integer.parseInt(categoryId));    
				request.setAttribute("product", productPerPage);
			}
			
			
			String productDetailId = request.getParameter("productDetailId");
			
			if (productDetailId != null) {
				ProductDetail productDetail = productDetailDAO.getProductDetailById(Long.parseLong(productDetailId));
				request.setAttribute("productDetail", productDetail );
			}
			else {
				productDetails = productDetailDAO.getAllProduct();
				request.setAttribute("productDetails", productDetails);
			}
			RequestDispatcher rd = request.getRequestDispatcher("productDetail.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
