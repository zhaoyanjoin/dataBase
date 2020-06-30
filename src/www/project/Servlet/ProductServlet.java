package www.project.Servlet;

import www.project.bean.Product;
import www.project.service.ProductService;
import www.project.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
//        System.out.println(method);
        if("findAllProduct".equals(method)){
            findAllProduct(request,response);
        }else if("showproductbyid".equals(method)){
            showProductById(request,response);
        }
    }

    private void showProductById(HttpServletRequest request, HttpServletResponse response) {
        String pro_id=request.getParameter("productid");
        ProductService ps = new ProductServiceImpl();
        Product product = ps.findProductById(Integer.parseInt(pro_id));
//        System.out.println(product);
        request.setAttribute("product",product);
        try {
            request.getRequestDispatcher("jsps/product_info.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAllProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService ps = new ProductServiceImpl();
        List<Product> reMenProduct = ps.findReMenProduct();
        List<Product> youXuanProduct = ps.findYouXuanProduct();
        request.setAttribute("reMenProduct",reMenProduct); //将热门商品存入作用域
        request.setAttribute("youXuanProduct",youXuanProduct);//将优选商品存入作用域
        try {
            request.getRequestDispatcher("jsps/showproduct.jsp").forward(request,response);//转发
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //测试
/*    private void findAllProduct() {
        ProductService ps = new ProductServiceImpl();
         List<Product> reMenProduct = ps.findReMenProduct();
         List<Product> youXuanProduct = ps.findYouXuanProduct();
        for (Product product : youXuanProduct) {
            System.out.println(product);
        }

    }*/


}
