package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductsDao;
import model.Products;

@WebServlet("/productServlet.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() {
        super();
    }
//当浏览器输入地址  ---》doGet方法
    //a链接触发 ---》doGet方法
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ProductsDao dao = new ProductsDao();
		ArrayList<Products> list = dao.findProductAll();
		request.setAttribute("prods", list);//内存 --》request
		if(list != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.getWriter().print("<h2>数据获取失败！！</h2>");
		}
	}
//当表单的提交方法 设置为post时 ---》doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
