package com.homework.exception;

public class ChongmingException extends  Exception {
    @Override
    public String getMessage() {
        return "已有用户注册,请重新输入.";
    }
}
