package test.tool;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
    public  static  void  shu(String name,String username,String password) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zuoye","root","123"
        );
        String sql = "insert into user values('"+name+"','"+username+"','"+password+"',1000)";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        conn.close();
        statement.close();


    }
}
