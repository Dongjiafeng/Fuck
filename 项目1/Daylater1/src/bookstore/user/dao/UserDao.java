package bookstore.user.dao;

import bookstore.user.Bean.User;
import bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr =  new QueryRunner();
    public User insertUser(User user){
        String sql = "insert  into tb_user values (?,?,?,?,?,?)";
        Connection conn=null;
        conn= JdbcUtil.getConnection();
        try {
                qr.update(conn,sql,
                    user.getUid(),user.getUsername(),user.getPassword(),
                    user.getEmail(),user.getCode(),user.isState());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
        return user;
    }
    public  User queryByUsername(String username){
        User user = new User();
        String sql = "select * from tb_user where username=?";
        Connection conn =null;
        conn = JdbcUtil.getConnection();
        try {
         user= qr.query(conn,sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
        return user;
    }
    public String queryByCode(String code){
        User user = new User();
        String sql = "select * from tb_user where code=? ";
        Connection conn = null;
        conn=JdbcUtil.getConnection();
        try {
           user= qr.query(conn,sql,new BeanHandler<User>(User.class),code);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        JdbcUtil.close(conn);
        return  user.getUsername();
    }

    public  void  updateState(boolean state,String code){
        String sql = "updata teacher set state=? where code=?";
        Connection conn = null;
        conn=JdbcUtil.getConnection();
        try {
            qr.update(conn,sql,state,code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);

    }
}
