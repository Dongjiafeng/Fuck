package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session =
                ServletActionContext.getRequest().getSession();
        Object username = session.getAttribute("username");
        if (username==null){
            return "Login";
        }else {
            return actionInvocation.invoke();
        }


    }
}
