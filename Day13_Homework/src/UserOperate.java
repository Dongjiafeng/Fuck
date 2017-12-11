import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;

public class UserOperate {
    public static void
    Login(String userName, String passWord) throws DocumentException {
//        for (Object user : UserData.users) {
//                Person person = (Person) user;
//                if(userName.equals(person.getUsername())&&passWord.equals(person.getPassword())){
//                    System.out.println("登录成功");
//                }
//                //System.out.println(user);
//
//        }
//        for (Object o :UserData.map.values()
//             ) {
//
//            Person person = (Person) o;
//            if(userName.equals(person.getUsername())&&passWord.equals(person.getPassword())){
//                System.out.println("登录成功");
//                System.out.println("姓名是:" + person.getName() + "职业是" + person.getJob());
//
//            }else {
//                System.out.println("你并没有注册过,请重新输入");
//            }
//        }
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/Date.xml");
        Element rootElement = document.getRootElement();
        Element person = rootElement.element("person");
        Attribute userName1 = person.attribute("username");
        Attribute password = person.attribute("passsword");
        if(userName.equals(userName1.getValue())&&passWord.equals(password.getValue())){
            System.out.println("登陆成功");
        }


    }

    public static void register(Person person) throws ToomuchException, IOException, DocumentException {
        Bbq.getDocument(person);
        //  UserData.users.add(person);

//        if(person.getPassword().length()>8){
//            throw new ToomuchException();
//
//
//
//        }
//
//
//        for (String s : UserData.map.keySet()) {
//            if(person.getUsername().equals(s)){
//                return false;
//            }
//        }
//        UserData.map.put(person.getUsername(),person);
//        return true;
//
//
//
////        Set<Map.Entry<String, Person>> entrySet = UserData.map.entrySet();
////        for (Map.Entry<String, Person> a : entrySet) {
////            if (person.getUsername().equals(a.getKey())){
////
////                return false;
////            }
////        }
////        UserData.map.put(person.getUsername(),person);
////        return true;
//
//
//
//
//
////        UserData.map.put(person.getUsername(), person);
//
////        if (person.getUsername().equals(UserData.map.keySet())){
////            return false;
////        }
////            return true;










    }

}








