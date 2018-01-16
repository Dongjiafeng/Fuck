package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();
    public  void addUser(User user){
        String sql = "insert into user values( ? , ? , ? , ? )";
        Connection conn = C3P0Util.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,null,conn);
        }
    }

    public User queryByName(String username){
        String sql = "select * from user where ?";
        Connection conn = C3P0Util.getConnection();
        try {
            User formBy = qr.query(conn, sql, new BeanHandler<User>(User.class), username);
            return formBy;
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

}
