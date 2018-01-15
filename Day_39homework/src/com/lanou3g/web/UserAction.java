package com.lanou3g.web;

import com.lanou3g.bean.User;
import com.lanou3g.service.UserService;
import com.lanou3g.service.exception.LoginException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    UserService userService = new UserService();
    public  String register(){
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        userService.reighter(user);
        return SUCCESS;
    }


    public String login(){
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        try {
            userService.login(user);
            return SUCCESS;
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return "false";
    }


}
