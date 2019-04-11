package filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.UsersDao;
import model.User;

public class AutoLoginFilter implements Filter{
	public void init(FilterConfig filterConfig)throws ServletException{		
	}
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain)throws IOException,ServletException{
		HttpServletRequest request = (HttpServletRequest)req;
		System.out.println("--------AutoLoginFilter--------");
		Cookie[] cookies = request.getCookies();
		String autologin = null;
		for(int i = 0;cookies!=null&&i<cookies.length;i++) {
			if("autologin".equals(cookies[i].getName())) {
				autologin = cookies[i].getValue();
				break;
			}
		}
		if(autologin!=null) {
			String[] parts = autologin.split("-");
			String username = parts[0];
			String password = parts[1];
			UsersDao dao = new UsersDao();
			User user = dao.findByUser(username, password);
			if(user!=null) {
				request.getSession().setAttribute("User",user);
			}
		}
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
