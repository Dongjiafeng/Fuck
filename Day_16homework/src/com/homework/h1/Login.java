package com.homework.h1;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Login {
    public static void Login1(String username, String  password) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/usersname.xml"));
        Element root = document.getRootElement();
        List<Element> person = root.elements("person");
        int i = 0;
        for (Element e :
                person) {
            Attribute usename = e.attribute("username");
            Attribute password1 = e.attribute("password");


            if (username.equals(usename.getValue()) && password.equals(password1.getValue())) {
                i =1;
                System.out.println("登陆成功");
            }

        }

        if (i == 0){
            System.out.println("你的帐号密码不正确");
        }


    }
}
