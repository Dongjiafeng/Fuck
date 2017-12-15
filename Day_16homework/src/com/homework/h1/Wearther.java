package com.homework.h1;

import com.homework.wenjian.Line;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Wearther {

    @Test
    public static void show(String  name) throws IOException {
        URL url = new URL("http://www.sojson.com/open/api/weather/json.shtml?city="+name);
       // URLConnection conn   = url.openConnection();
        //InputStream is =conn.getInputStream();
        InputStream coon = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = coon.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if (coon != null) {
                coon.close();
            }
        }
        //byte[] by  =new byte[1024*1024*1000];
        //int len = is.read(by);
       // String result = new String(by,0,len);
       // System.out.println(result);
        byte[] b = out.toByteArray();
        // System.out.print(new String(b,"UTF-8") );
        String str = new String(b);


        JSONObject js =JSONObject.fromObject(str);
        Line book = (Line) JSONObject.toBean(js,Line.class);
        System.out.println("城市是"+book.getCity()+"日期是"+book.getDate());
    }
}
