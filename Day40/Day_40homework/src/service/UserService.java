package service;

import bean.User;
import dao.UserDao;
import service.Exception.NameNullException;
import service.Exception.PasswordNullException;

import javax.security.auth.login.LoginException;

public class UserService {
    private UserDao userDao = new UserDao();
    public void register(User user)  {
        User formBy = userDao.queryByName(user.getUsername());
        if (formBy==null){
            userDao.addUser(user);
//            throw new LoginException();
        }


    }
    public User login(String username,String password) throws  NameNullException, PasswordNullException {
        User user = userDao.queryByName(username);
        if (user==null){
           throw new NameNullException();
        }
        if (!user.getPassword().equals(password)){
            throw  new PasswordNullException();
        }
        return user;
    }
}
