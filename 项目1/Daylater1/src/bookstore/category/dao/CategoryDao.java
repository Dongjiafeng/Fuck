package bookstore.category.dao;

import bookstore.category.domain.Category;
import bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner qr = new QueryRunner();
    public List<Category> queryAll(){
        String sql = "select * from category";
        Connection conn = null;
        conn= JdbcUtil.getConnection();
        try {
            List<Category> categories = qr.query(conn, sql, new BeanListHandler<Category>(Category.class));
            System.out.println(categories);
            return  categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
        return  null;
    }
}
