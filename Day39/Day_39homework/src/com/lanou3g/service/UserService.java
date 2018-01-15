package com.lanou3g.service;

import com.lanou3g.bean.User;
import com.lanou3g.dao.UserDao;
import com.lanou3g.service.exception.InvalidUsernameException;
import com.lanou3g.service.exception.LoginException;
import com.lanou3g.service.exception.PasswordNotMatchedException;

import java.util.List;

public class UserService  {
    private UserDao userDao = new UserDao();

    public User login(User user) throws LoginException {

        User fromDb = userDao.queryByUsername(user.getUsername());

        if(fromDb == null){
            throw new InvalidUsernameException();
        }


        if(!fromDb.getPassword().equals(
                user.getPassword()
        )){

            throw new PasswordNotMatchedException();
        }

        return fromDb;
    }

    public void reighter(User user){
        UserDao userDao = new UserDao();
        userDao.insert(user);
    }
}
