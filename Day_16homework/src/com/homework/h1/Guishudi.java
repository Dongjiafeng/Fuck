package com.homework.h1;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Guishudi {

    public static   void show(int name) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+name+"&appkey=30522&sign=23e66de6ea94d0ac260642a9b714bffe&format=json");
//        URLConnection conn   = url.openConnection();
//        InputStream is =conn.getInputStream();
        InputStream conn = url.openStream();
        ByteArrayOutputStream out  = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = conn.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }finally {
            if (conn != null){
                conn.close();
            }


        }
        byte[] b = out.toByteArray();
        String str =new String(b);


//        String result = new String(by,0,len);
//        System.out.println(result);
        JSONObject js =JSONObject.fromObject(str);
        Guishudichajian gsd  =(Guishudichajian)JSONObject.toBean(js,Guishudichajian.class);

    }
}
