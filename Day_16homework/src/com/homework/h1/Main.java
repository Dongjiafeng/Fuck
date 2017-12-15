package com.homework.h1;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException, InterruptedException {

        chongxin();



    }

    public static void chongxin() throws IOException, DocumentException, InterruptedException {
        Scanner input  = new Scanner(System.in);
        System.out.println("请注册,请输入昵称");
        String name1 = input.nextLine();
        System.out.println("请输入你的帐号");
        String username1 = input.nextLine();
        System.out.println("请输入你的密码");
        String password1 = input.nextLine();
        Person person = new Person(name1,username1,password1);
        Dataopen.register(name1,username1,password1,person);
        System.out.println("请登录,请输入帐号");
        String name2 = input.nextLine();
        System.out.println("请输入密码");
        String password2 = input.nextLine();
        Login.Login1(name2,password2);
        System.out.println("恭喜成功登录"+person.toString());
        System.out.println("请选择功能:  1.查询天气   2.查询手机号归属地 3.手速游戏  4查询手机前十用户 ");
        int choose = input.nextInt();
        switch (choose){
            case 1:
                input.nextLine();
                System.out.println("请输入你需要查看的城市.");
                String name = input.nextLine();
                Wearther.show(name);
                break;
            case 2:
                input.nextLine();
                System.out.println("请输入你需要查看的电话号码");
                int phone = input.nextInt();
                Guishudi.show(phone);
                break;
            case 3:
                System.out.println("请选择等级  1.简单   2.中等  3.困难");
                int choose1 = input.nextInt();
            switch (choose1){
                case 1:
                    for (int i = 3; i >0 ; i--) {
                        System.out.println("倒数"+i+"秒后开始输出");
                        Thread.sleep(1000);
                    }
                    long l  = System.currentTimeMillis();
                       String a =Youxi.show();
                    System.out.println(a);
                    String  a1 =input.nextLine();
                    long p=System.currentTimeMillis();
                    long time  = p-l;
                    if (a.equals(a1)){
                        System.out.println("你的时间是"+time+"毫秒");
                    }else {
                        System.out.println("回答有误,挑战失败");
                    }
                    Score.show(time,person.getName());

                    break;
                case 2:
                    for (int i = 3; i >0 ; i--) {
                        System.out.println("倒数"+i+"秒后开始输出");
                        Thread.sleep(1000);
                    }
                    long l2=System.currentTimeMillis();
                    String b  =Youxi.show2();
                    System.out.println(b);
                    String  b1 =input.nextLine();
                    long p2=System.currentTimeMillis();
                    long time2  = p2-l2;
                    if (b.equals(b1)){
                        System.out.println("你的时间是"+time2+"毫秒");
                    }else {
                        System.out.println("回答有误,挑战失败");
                    }
                    Score.show(time2,person.getName());
                    break;
                case 3:
                for (int i = 3; i >0 ; i--) {
                    System.out.println("倒数"+i+"秒后开始输出");
                    Thread.sleep(1000);
                }
                    long l3=System.currentTimeMillis();
                    String c =Youxi.show3();
                    System.out.println(c);

                    String  c1 =input.nextLine();

                    long p3=System.currentTimeMillis();
                    long time3  = p3-l3;
                    if (c.equals(c1)){
                        System.out.println("你的时间是"+time3+"毫秒");

                    }else {
                        System.out.println("回答有误,挑战失败");
                    }
                    Score.show(time3,person.getName());
                    break;
        }

                break;
            case 4:





        }
    }
}
