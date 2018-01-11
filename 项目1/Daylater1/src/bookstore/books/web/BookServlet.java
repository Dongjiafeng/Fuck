package bookstore.books.web;

import bookstore.books.bookdao.BookDao;
import bookstore.books.domain.Book;
import bookstore.category.domain.Category;
import bookstore.shopping.domain.CartItem;
import bookstore.shopping.shoppingDao.ShoppingDao;
import bookstore.user.dao.UserDao;
import bookstore.util.BaseServlet;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private  ShoppingDao shoppingDao = new ShoppingDao();
    private  BookDao bookDao  = new BookDao();
    private  Category category = new Category();
    public String books(HttpServletRequest request, HttpServletResponse response){
        List<Book> books = bookDao.queryAll();
        request.setAttribute("book",books);
        System.out.println("books被调用了");
        //指定一个路径
        //还得让他的父类BaseServlet能获得
        return "f:/jsps/book/list.jsp";
    }

    public String bookSe(HttpServletRequest request,HttpServletResponse response){
        Category idcard = shoppingDao.findBookCname("JavaSE");
        int cid = idcard.getCid();
        List<Book> books = bookDao.queryUid(cid);
        request.setAttribute("bookse",books);

        System.out.println("bookSe被调用了");
        return "f:/jsps/book/list.jsp";
    }

    public String bookEe(HttpServletRequest request,HttpServletResponse response){
        Category idcard = shoppingDao.findBookCname("JavaEE");
        System.out.println(idcard);
        int cid = idcard.getCid();
        List<Book> books = bookDao.queryUid(cid);
        request.setAttribute("bookee",books);

        System.out.println("bookEe被调用了");
        return "f:/jsps/book/list.jsp";
    }

    public String bookLe(HttpServletRequest request,HttpServletResponse response){
        Category idcard = shoppingDao.findBookCname("Javascript");
        int cid = idcard.getCid();
        List<Book> books = bookDao.queryUid(cid);
        request.setAttribute("bookLe",books);

        System.out.println("bookLe被调用了");
        return "f:/jsps/book/list.jsp";
    }



}