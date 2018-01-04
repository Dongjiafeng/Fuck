package homework.web;

import homework.Dao.BookDao;
import homework.users.Books;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "InsertBookServlet",urlPatterns = "/insertBook")
public class InsertBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        Books books = new Books();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(books,parameterMap);
            String bookName = books.getBookName();
            Books query = bookDao.query(bookName);
            if(query != null){
                response.sendRedirect("/index.jsp");

                return;
            }

            if(bookDao.query(books.getBookName())== null)

                bookDao.insert(books);

            response.sendRedirect("/homepage.jsp");
            getServletContext().setAttribute("books",books);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
