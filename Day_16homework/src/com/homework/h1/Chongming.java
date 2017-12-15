package com.homework.h1;

import com.homework.exception.ChongmingException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Chongming {
    public  static void show(String username) throws ChongmingException, DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document =saxReader.read(new File("src/usersname.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements("person");

        for (Element e:elements
                ) {

            if (username.equals(e.attribute("username").getValue())){
                throw new ChongmingException();


            }

        }
    }
}
