package servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Products;

@WebServlet("/updateCart.do")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateCartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String count = request.getParameter("count");
		HttpSession session = request.getSession();
		if (session.getAttribute("cart")!=null) {
			Map<Products, Integer> cart = (Map<Products, Integer>)session.getAttribute("cart");
			Set<Products> keySet = cart.keySet();
			for (Products products : keySet) {				
				if (products.getId().equals(id)) {
					cart.put(products,Integer.parseInt(count));
					break;
				}
			}
		}else {
			//购物车无内容
		}
		response.sendRedirect("shopping.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
