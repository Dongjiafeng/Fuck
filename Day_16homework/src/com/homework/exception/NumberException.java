package com.homework.exception;

public class NumberException extends Exception {

    @Override
    public String getMessage() {
        return "注册帐号必须是手机号或邮箱";
    }
}
