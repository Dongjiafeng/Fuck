package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.Exception.NameNullException;
import service.Exception.PasswordNullException;
import service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAction extends ActionSupport implements ModelDriven<User> ,ServletRequestAware{
    private HttpServletRequest request;
    private  User user = new User();
    private UserService userService = new UserService();
    private String repassword;

    public String register(){
//        try {
            userService.register(user);
            return SUCCESS;
//        } catch (LoginException e) {
//            e.printStackTrace();
//        }
//        return SUCCESS;
  }

    public String login(){
        try {
            User fromBy = userService.login(user.getUsername(), user.getPassword());
            request.getSession().setAttribute("username",fromBy.getUsername());
            return SUCCESS;
        } catch (NameNullException e) {
            e.printStackTrace();
        } catch (PasswordNullException e) {
            e.printStackTrace();
        }
        return ERROR;

    }
    @Override
    public User getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
