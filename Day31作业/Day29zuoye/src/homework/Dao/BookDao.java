package homework.Dao;


import homework.users.Books;
import homework.users.User;
import homework.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
            private  QueryRunner qr = new QueryRunner();
        public void  insert(Books books){
            String sql = "insert into books values(null,?,?,?)";
            Connection conn = null;
            conn = JdbcUtil.getConnection();
            try {
                qr.update(conn,sql,books.getBookName(),books.getAuthor(),books.getPrice());
            } catch (SQLException e) {
                e.printStackTrace();
            }
             JdbcUtil.close(conn);
        }
        public Books query(String bookName) {
            String sql =
                    "select * from books where bookName=?";

            Connection conn = JdbcUtil.getConnection();
            Books books = new Books();

            try {
                books = qr.query(conn, sql, new BeanHandler<Books>(Books.class), bookName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return books;

        }
     public List<Books> queryAll() {
        String sql = "select * from books";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            List<Books>  books=
                    qr.query(conn, sql, new BeanListHandler<Books>(Books.class));
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return null;
    }

}
