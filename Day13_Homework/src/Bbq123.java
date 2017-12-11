import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;


public class Bbq123 {
    static SAXReader saxReader = new SAXReader();
    static Document document = null;
    public static void addXml(Person person) throws IOException, DocumentException {

        document = saxReader.read("src/Data.xml");
        Element rootElement = document.getRootElement();

//        Element elements = document.addElement("persons");
        Element element = rootElement.addElement("person");
        element.addAttribute("name",person.getName());
        element.addAttribute("userName",person.getUsername());
        element.addAttribute("passWord",person.getPassword());
        element.addAttribute("job",person.getJob());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/Data.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        System.out.println("注册成功");

    }


}
