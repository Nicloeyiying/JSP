package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDao;
import dao.UsersDao;
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------doGet-------------");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		UsersDao dao = new UsersDao();
		User user = dao.findByUser(name, pwd);
		if(user!=null) {
			request.getSession().setAttribute("User", user);
			String autoLogin = request.getParameter("autologin");
			if(autoLogin!=null) {
				Cookie cookie = new Cookie("autologin", name+"-"+pwd);
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			response.sendRedirect("index.jsp");
		}else {
			request.getSession().setAttribute("message", "【用户名或密码错误，请重新输入！】");
			response.sendRedirect("login.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}
}
