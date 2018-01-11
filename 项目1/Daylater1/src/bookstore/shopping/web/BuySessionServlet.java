package bookstore.shopping.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BuySessionServlet")
public class BuySessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取商品id
        String bid = request.getParameter("bid");
        //获得购物车.cart
        HttpSession session = request.getSession();
        Map<String,Integer > cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart==null){
            cart = new HashMap<String, Integer>();
        }
        if (cart.containsKey(bid)){
            int number = cart.get(bid);
            cart.put(bid,number+1);

        }else {
            cart.put(bid,1);
        }
        session.setAttribute("cart",cart);
        response.sendRedirect("");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
