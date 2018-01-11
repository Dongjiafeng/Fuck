package bookstore.shopping.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddcookieServlet")
public class AddcookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //自动刷新
        response.setHeader("refresh", "2;url=");
        //获取商品的id
        String bid = request.getParameter("bid");
        Cookie[] cookies = request.getCookies();
        //查找访问列表
        String visitlist = null;
        //存在Cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitlist")) {
                    visitlist = cookie.getValue();
                    break;
                }
            }
            if (visitlist == null) {
                //列表不存在
                Cookie cookie = new Cookie("visitlist", bid);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.getWriter().write("add SUCCESS");
            } else {
                //列表存在
                String[] existids = visitlist.split(",");
                for (String existid : existids) {
                    if (existid.equals(bid)) {
                        response.getWriter().write("add SUCCESS");
                        return;
                    }
                }
                // 4、如果当前商品不在列表中，添加到列表
                Cookie cookie = new Cookie("visitlist", visitlist + "," + bid);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.getWriter().println("add success");
            }
        }else{
            // 表示 并没有该站点的任何cookie
            Cookie cookie = new Cookie("visitlist", bid);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            response.getWriter().println("add success");
        }
    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
