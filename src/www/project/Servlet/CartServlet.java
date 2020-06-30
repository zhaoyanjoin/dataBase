package www.project.Servlet;

import www.project.bean.Product;
import www.project.service.ProductService;
import www.project.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 赵岩
 * @create 2020-06-16 19:17
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
//        System.out.println(method);
        if("buyProduct".equals(method)){
            addProductToCart(request,response);
        }else if("deleteProduct".equals(method)){
            deleteProduct(request,response);
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        //获得删除商品的id
        System.out.println("我来了");
        int proId=Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        Map<Product,Integer> mapCart = (Map<Product, Integer>) session.getAttribute("cartMap");
        Set<Product> set = mapCart.keySet();
        Product pro=null;
        for (Product product : set) {
            if(product.getPro_id()==proId){
                pro=product;
                break;
            }
        }
        mapCart.remove(pro);//删除指定商品
        try {
            response.sendRedirect("jsps/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(request.getParameter("pro_id").getClass());
        //获得商品的id
        String pro_id = request.getParameter("pro_id");
        //获得商品的数量
        String quantity = request.getParameter("quantity");
        //获得对应ID的商品的全部属性
        ProductService service = new ProductServiceImpl();
//        System.out.println(pro_id.getClass());
        int proid = new Integer(pro_id);
        Product  product= service.findProductById(proid);
        //获取Session
        HttpSession session = request.getSession();
        Map<Product,Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
        if(cartMap==null){//第一次来
            cartMap = new HashMap<Product,Integer>();
            cartMap.put(product,new Integer(quantity));
            session.setAttribute("cartMap",cartMap);
        }else{
            boolean flag = false;//false表示不包含
            Product productRep=null;//用来记录哪个商品包含
            Set<Product> set = cartMap.keySet();
            for (Product pro : set) {
                if(pro.getPro_id()==product.getPro_id()){
                    flag=true;
                    productRep=pro;
                    break;
                }
            }
            if(flag){//包含,将数量叠加
                Integer num = Integer.parseInt(quantity)+cartMap.get(productRep);
                cartMap.put(productRep,num);
                session.setAttribute("cartMap",cartMap);
            }else{//不包含,存入集合
                cartMap.put(product,new Integer(quantity));
                session.setAttribute("cartMap",cartMap);
            }

        }
       /* boolean flag=true;
        for (Product pro : set) {
            if(pro.getPro_id()==product.getPro_id()){
                flag=false;
                break;
            }
        }
        if(flag){


        }else{
            Map<Product,Integer> cartMap = new HashMap<Product,Integer>();
            cartMap.put(product,new Integer(quantity));
            HttpSession sess = request.getSession();
            sess.setAttribute("cartMap",cartMap);
        }*/
        try {
            response.sendRedirect("jsps/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
