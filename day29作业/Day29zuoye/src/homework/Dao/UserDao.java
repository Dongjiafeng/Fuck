package homework.Dao;

import homework.users.User;
import homework.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public void insertUser(User user) {
        String sql = "insert  into user values (null,?,?)";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
            JdbcUtil.close(conn);
    }


    public List<User> queryAll(){
        String sql = "select * from user";
        Connection conn;
        conn= JdbcUtil.getConnection();

        try {
            List<User> query = qr.query(conn, sql, new BeanListHandler<User>(User.class));
            return  query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

}
