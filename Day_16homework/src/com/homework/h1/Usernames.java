package com.homework.h1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Usernames {
      static SAXReader saxReader = new SAXReader();
       static Document document = null;



    public  static void open(Person person) throws DocumentException, IOException {

       document = saxReader.read(new File("src/usersname.xml"));

           Element root = document.getRootElement();
//        Element users = document.addElement("users");
        Element person1 = root.addElement("person");
        person1.addAttribute("username",person.getUsername());
        person1.addAttribute("password",person.getPassword());
        person1.addAttribute("name",person.getName());
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xw   = new XMLWriter(new FileWriter("src/usersname.xml"),outputFormat);
        xw.write(document);
        xw.close();


    }
}
