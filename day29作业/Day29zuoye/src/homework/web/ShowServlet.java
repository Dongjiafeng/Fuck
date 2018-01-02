package homework.web;

import homework.Dao.UserDao;
import homework.users.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = null;
        users = userDao.queryAll();
        for (User user : users) {
            if( user.getUsername().equals(username)&& user.getPassword().equals(password)){
                request.getRequestDispatcher("http://localhost:8080/homepage.html");

            }else {
                request.getRequestDispatcher("http://localhost:8080/index.jsp");
                }

          }

        JSONArray jsonArray=JSONArray.fromObject(users);
        response.getWriter().write(jsonArray.toString());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
