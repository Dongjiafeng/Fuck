package bookstore.shopping.shoppingDao;

import bookstore.category.domain.Category;
import bookstore.shopping.domain.CartItem;
import bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ShoppingDao {
    private QueryRunner qr  =new QueryRunner();

    public CartItem queryUid(String cid){
        String sql = "select * from book where bid=?";
        Connection conn = null;
        try {
            conn= JdbcUtil.getConnection();
            CartItem cartItem = qr.query(conn, sql, new BeanHandler<CartItem>(CartItem.class), cid);
            System.out.println(cartItem);
            return cartItem;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return  null;


    }
    public Category findBookCname(String cname){
        String sql = "select * from category where cname = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            Category book = qr.query(conn, sql,new BeanHandler<Category>(Category.class),cname);
            System.out.println(book);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
