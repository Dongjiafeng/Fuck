package bookstore.category.web;

import bookstore.category.dao.CategoryDao;
import bookstore.category.domain.Category;
import bookstore.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends BaseServlet {
    CategoryDao categoryDao = new CategoryDao();
    public  String findAll(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
        List<Category> category = categoryDao.queryAll();

        request.setAttribute("category",category);
        return  "f:/adminjsps/admin/category/list.jsp";
    }
}
