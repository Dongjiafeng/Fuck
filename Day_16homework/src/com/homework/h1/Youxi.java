package com.homework.h1;

import java.util.Random;
import java.util.Scanner;

public class Youxi {




    public static String show(){
        int length = 10;
        String str  = "zxcvbnmasdfghjklpoiuytrewq0123456789";
        Random random  = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <length ; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));

        }
        return sb.toString();

    }
    public  static  String show2(){
        int length = 20;
        String str = "zxcvbnmasdfghjklpoiuytrewqZXCVBNMLKJHGFDSAQWERTYUIOP0123456789";
        Random random = new Random();
        StringBuffer sb  = new StringBuffer();
        for (int i = 0; i <length ; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static  String show3(){
        int length =30;
        String str = "zxcvbnmasdfghjklpoiuytrewqZXCVBNMLKJHGFDSAQWERTYUIOP0123456789~!@#$%^&*(){}:|<>?-=+";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <length ; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
