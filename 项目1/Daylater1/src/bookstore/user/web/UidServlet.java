package bookstore.user.web;

import bookstore.user.Bean.User;
import bookstore.user.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UidServlet",urlPatterns = "/uid")
public class UidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String code = request.getParameter("code");
        String username = userDao.queryByCode(code);
        System.out.println(code);
        System.out.println(username);
        if (username==null && username==""){
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            response.getWriter().write("无用户信息");
        }
            response.sendRedirect("/jsps/user/login.jsp");


    }

}
