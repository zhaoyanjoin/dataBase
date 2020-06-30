package www.project.Filter;

import www.project.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 赵岩
 * @create 2020-06-17 20:31
 */
@WebFilter(urlPatterns ={"/PayServlet","/CartServlet","/jsps/cart.jsp"})
public class logoinFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("user");
        if(user!=null){
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect(request.getContextPath()+"/jsps/login.jsp?msg=login");
        }




    }

    public void init(FilterConfig config) throws ServletException {

    }

}
