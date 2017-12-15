package com.homework.exception;

public class ShortException extends  Exception {
    @Override
    public String getMessage() {
        return "密码一定要有大小写字母,请重新输入";
    }
}
