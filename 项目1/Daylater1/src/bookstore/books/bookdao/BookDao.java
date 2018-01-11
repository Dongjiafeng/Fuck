package bookstore.books.bookdao;

import bookstore.books.domain.Book;
import bookstore.user.Bean.User;
import bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public List<Book> queryAll(){
        String sql = "select * from book";
        Connection conn =null;
        conn= JdbcUtil.getConnection();
        try {
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return null;
    }
    public List<Book> queryUid(int cid){

        String sql = "select * from book where cid=?";
        Connection conn = null;
        try {
            conn=JdbcUtil.getConnection();
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class), cid);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return  null;


    }
}
