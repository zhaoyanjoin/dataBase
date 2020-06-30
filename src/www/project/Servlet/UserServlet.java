package www.project.Servlet;

import www.project.bean.User;
import www.project.service.UserService;
import www.project.serviceImpl.UserServiceImpl;
import www.project.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method=request.getParameter("method");

        if("login".equals(method)){

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserServiceImpl usi = new UserServiceImpl();
            User user =  usi.checkUser(username,password);

            if(user != null){//登录成功，并将用户信息装入session域中
//                System.out.println("登录成功");
                HttpSession sess = request.getSession();
                sess.setAttribute("user",user);
                response.sendRedirect("jsps/index.jsp");

            }else{//登录失败
                System.out.println("登录失败");

                response.sendRedirect("jsps/login.jsp?msg=false");
            }

        }else if("register".equals(method)){
            //获取web端传来的数据
            String  username =  request.getParameter("username");
            String  password = request.getParameter("password");
            String Email = request.getParameter("Email");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String birthday = request.getParameter("birthday");
            //将传来的参数封装进对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(Email);
            user.setName(name);
            user.setSex(sex);
            user.setBirthday(DateUtils.stringToDate(birthday));
            //调用函数添加数据到数据库
            UserService us = new UserServiceImpl();
            int num =  us.addUser(user);
            if(num>0){
                System.out.println("添加成功");
                response.sendRedirect("jsps/login.jsp");
            }else{
                System.out.println("添加失败");
                response.sendRedirect("jsps/register.jsp");
            }
        }else if("exitLogin".equals(method)){
            HttpSession sess = request.getSession();
            sess.removeAttribute("user");
            response.sendRedirect(request.getContextPath()+"/jsps/index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
