package bookstore.shopping.web;

import bookstore.books.bookdao.BookDao;
import bookstore.books.domain.Book;
import bookstore.shopping.domain.CartItem;
import bookstore.shopping.shoppingDao.ShoppingDao;
import bookstore.util.BaseServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet" ,urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private ShoppingDao shoppingDao = new ShoppingDao();
    public String  findAll(HttpServletRequest request,HttpServletResponse response){
        String count = request.getParameter("count");
        String bid = request.getParameter("bid");
        CartItem cartItem = shoppingDao.queryUid(bid);
        System.out.println("1____________________");
        cartItem.setCount(count);
        Map<String,CartItem> cart = (Map<String,CartItem>)request.getSession().getAttribute("cart");
        if(cart==null){
            cart = new HashMap<String, CartItem>();
        }

        cart.put(cartItem.getBid(),cartItem);


        request.getSession().setAttribute("cart",cart);
        System.out.println("2--------------");
        return "f:/jsps/cart/list.jsp";
    }
    public  String findbook(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        CartItem car = shoppingDao.queryUid(bid);
        request.getSession().setAttribute("All",car);
        return "f:/jsps/book/desc.jsp";
    }

    public  String clear(HttpServletRequest request ,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        return "f:/jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request ,HttpServletResponse response){
        HttpSession session = request.getSession();
        Map<String,CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        String bid = request.getParameter("bid");
        cart.remove(bid);
        return "f:/jsps/cart/list.jsp";
    }

}
