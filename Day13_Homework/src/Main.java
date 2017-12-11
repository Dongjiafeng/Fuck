import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DocumentException {
        Person person = null;
        Scanner input =new Scanner(System.in);
        while (true){System.out.println("欢迎来到BAT:1.注册    2.登录");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    input = new Scanner(System.in);
                    System.out.println("请输入姓名:");
                    String names = input.nextLine();

                    System.out.println("请输入用户名:");
                    String usernames = input.nextLine();
                    System.out.println("请输入密码");
                    String password2 = input.nextLine();
                    System.out.println("请选择职业:1.Worker  2.Cooker  3.Teacher 4.Boss");
                    int choose1 = input.nextInt();
                    switch (choose1) {
                        case 1:
                            person = new Worker(names, usernames, password2, "Worker");
                            break;
                        case 2:
                            person = new Teacher(names, usernames, password2, "Teacher");
                            break;
                        case 3:
                            person = new Cooker(names, usernames, password2, "Cooker");
                            break;
                        case 4:
                            person = new Boss(names, usernames, password2, "Boss");
                            break;
                    }
//                    try {
//                        if (UserOperate.register(person)){
//                            System.out.println("注册成功");
//
//                        }else {
//                            System.out.println("你的帐号有人使用,请重新注册.");
//                            continue;
//                        }
//                    } catch (ToomuchException e) {
//                        System.out.println(e.getMessage());
//                    }

                    try {
                        UserOperate.register(person);
                    } catch (ToomuchException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }


                    for (Object o1:UserData.map.keySet()) {
                        System.out.println(UserData.map.get(o1));
                    }






                    break;
                case 2:
                    input.nextLine();
                    System.out.println("请输入用户名:");
                    String users = input.nextLine();
                    System.out.println("请输入密码:");
                    String password = input.nextLine();

                    UserOperate.Login(users,password);
                    break;

            }
        }
    }
}
