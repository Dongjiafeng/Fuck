package bookstore.user.web;

import bookstore.books.bookdao.BookDao;
import bookstore.books.domain.Book;
import bookstore.shopping.domain.CartItem;
import bookstore.user.Bean.User;
import bookstore.user.service.Exception.LoginException;
import bookstore.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    private BookDao bookDao = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User userf = new User();
        userf.setUsername(username);
        userf.setPassword(password);

        User login = null;
        try {
            login = userService.LoginUser(userf);
            request.getSession().setAttribute("user",login);


        } catch (LoginException e) {
            request.setAttribute("errorMsg",e.getMessage());
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
