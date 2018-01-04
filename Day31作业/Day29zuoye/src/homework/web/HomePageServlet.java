package homework.web;

import homework.Dao.BookDao;
import homework.users.Books;
import homework.users.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet",urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {
    private BookDao bookDao = new BookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        List<Books> books = bookDao.queryAll();

        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());
//        User user =
//                (User) getServletContext()
//                        .getAttribute("user");
//
//        JSONObject jsonObject =
//                JSONObject.fromObject(user);
//
//        response.getWriter().write(jsonObject.toString());


    }
}