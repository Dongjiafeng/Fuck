package bookstore.user.service;

import bookstore.user.Bean.User;
import bookstore.user.dao.UserDao;
import bookstore.user.service.Exception.*;
import bookstore.util.EmailUtil;

import javax.mail.MessagingException;
import java.util.regex.Pattern;

public class UserService {
    private UserDao userDao = new UserDao();
    private EmailUtil emailUtil = new EmailUtil();
    public void registerUser(User user) throws RegisterException,MessagingException{
        Pattern compile = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        User usertwo = userDao.insertUser(user);
        User userBy = userDao.queryByUsername(user.getUsername());
        String email1 = usertwo.getEmail();
//        if (!usertwo.getEmail().equals(email1.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"))){
//            System.out.println("0"+"==========");
//            throw new NotemailException();
//        }
//        if (userBy.getUsername().equals(usertwo.getUsername())){
//            System.out.println("1==================");
//            throw new SameUsernameException();
//        }
        String email = usertwo.getEmail();
        String s = emailUtil.t1(email);
        System.out.println(s+"=---------------------------------------");
        usertwo.setCode(s+s);
        usertwo.setUid(s);
        usertwo.setState(false);

    }

    public User LoginUser(User user) throws LoginException {
        User userBy = userDao.queryByUsername(user.getUsername());
        if (userBy==null){
            throw  new InvalidUsernameException();
        }
        if (!userBy.getPassword().equals(user.getPassword())){
            throw  new PasswordNotMatchedException();
        }

        return userBy;
    }

}
