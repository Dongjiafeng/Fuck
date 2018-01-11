package bookstore.user.web;

import bookstore.user.Bean.User;
import bookstore.user.dao.UserDao;
import bookstore.user.service.Exception.RegisterException;
import bookstore.user.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao  =new UserDao();
        User user = new User();
        UserService userService = new UserService();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            try {
                 userService.registerUser(user);
            } catch (RegisterException e) {
                e.getMessage();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            userDao.insertUser(user);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
