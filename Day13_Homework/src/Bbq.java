import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bbq {
    static Document document = null;
    static SAXReader saxReader = new SAXReader();

    public static void getDocument(Person person) throws IOException, DocumentException {
         document = saxReader.read(new File("src/Date.xml"));
//        Element elements = document.addElement("persons");
        Element rootElement = document.getRootElement();
        Element element = rootElement.addElement("person");
//        Element element = elements.addElement("person");
        element.addAttribute("username",person.getUsername());
        element.addAttribute("name",person.getName());
        element.addAttribute("passsword",person.getPassword());
        element.addAttribute("job",person.getJob());
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("utf-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/Date.xml"),prettyPrint);
        xmlWriter.write(document);
        xmlWriter.close();
        System.out.println("注册成功");


    }
}
