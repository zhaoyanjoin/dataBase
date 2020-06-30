package www.project.Servlet;

import www.project.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author 赵岩
 * @create 2020-06-17 19:16
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        System.out.println("&&&&&&");
        String msg = request.getParameter("msg");
        if("payAll".equals(msg)){
            payAll(request,response);
        }
        
    }

    private void payAll(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sess = request.getSession();
        //获得购物车商品信息
        Map<Product,Integer> map = (Map<Product,Integer> )sess.getAttribute("cartMap");
        if(map!=null){//如果购物车有商品
            Set<Product> set = map.keySet();
            double total=0;
            for (Product pro : set) {//计算商品总和
                double money = pro.getShop_price()*map.get(pro);
                total+=money;
            }
            sess.setAttribute("total",total);
//            System.out.println("------");
            try {
                response.sendRedirect("jsps/pay.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {//如果没有商品
//            System.out.println("***********");
            try {
                response.sendRedirect("jsps/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        
        
        
        
        
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
