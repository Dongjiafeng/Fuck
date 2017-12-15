package com.homework.exception;

public class ShuziException extends  Exception {
    @Override
    public String getMessage() {
        return "没有数字,请重新输入";
    }
}
