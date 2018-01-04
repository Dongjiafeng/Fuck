package homework.web;

import homework.Dao.UserDao;
import homework.users.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "InsertServlet" ,urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Map<String, String[]> parameterMap =
                request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            String formName = user.getUsername();
            User fromDb = userDao.queryAll(formName);

            if(fromDb != null){
                response.sendRedirect("/Reigster.html");

                return;
            }

            if(userDao.queryAll(user.getUsername())== null)

                userDao.insertUser(user);

            response.sendRedirect("/index.jsp");


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
