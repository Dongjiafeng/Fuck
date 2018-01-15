package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
        private QueryRunner qr =  new QueryRunner();

    public  List<User> query() {
        String sql = "select * from user ";
        Connection conn = C3P0Util.getConnection();
        try {
            List<User> users = qr.query(conn, sql, new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,null,conn);
        }
        return null;
    }

    public void insert(User user){
        String sql = "insert into user values(?,?)";
        Connection conn = C3P0Util.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
             C3P0Util.release(null,null,conn);
        }
    }
    public  User queryByUsername (String username) {
        String sql = "select * from user where ? ";
        Connection conn = C3P0Util.getConnection();
        try {
            User userone = qr.query(conn, sql, new BeanHandler<User>(User.class), username);
            return userone ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,null,conn);
        }
        return null;
    }
}
