package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDao;
import model.Products;

@WebServlet("/addCart.do")
public class addCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addCartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//提交的书本id  bookId
		String[] ids = request.getParameterValues("bookId");
		if(ids!=null) {
			Map<Products, Integer> cart = null;
			//判断在作用域中是否有map
			HttpSession session = request.getSession();
			//第一次购买
			if(session.getAttribute("cart")==null) {
				cart = new HashMap<Products, Integer>();
				session.setAttribute("cart", cart);//只需要保存一次
			}else {//后续购买
				cart = (Map<Products, Integer>)session.getAttribute("cart");
			}
			for (int i = 0; i < ids.length; i++) {
				ProductsDao dao = new ProductsDao();
				Products prods = dao.findProductsById(ids[i]);
				if(cart.containsKey(prods)) {
					//如果购物车中有这个商品 商品数量加1
					Integer count = cart.get(prods);
					cart.put(prods, count+1);
				}else { //第一次购买
				  cart.put(prods, 1);
				}				
			}
			//将页面跳转到 shopping.jsp
			response.sendRedirect("shopping.jsp");
		}else {
			response.getWriter().print("<h2>您没有选中任何商品...</h2>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
