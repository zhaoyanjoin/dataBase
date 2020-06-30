package www.project.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 赵岩
 * @create 2020-06-17 22:10
 */
@WebFilter(urlPatterns = "/testServlet")
public class testFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter  ---->");
        chain.doFilter(req, resp);
        System.out.println("filter  <----");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
