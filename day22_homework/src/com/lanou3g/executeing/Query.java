package com.lanou3g.executeing;

import com.lanou3g.database.JdbcUtil;
import com.lanou3g.dbUtil.DbQueryRunner;
import com.lanou3g.userdao.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Query {


public static void main(String[] args) {
    query();

}

    public static List<User>  query() {
        try {
            List<User> users = new DbQueryRunner().query(
                    JdbcUtil.getConn(),
                    "select * from stu_user",
                    new BeanListHandler<>(User.class)
            );

            for (User u : users) {
                System.out.println(u);
            }

            return users;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




}
