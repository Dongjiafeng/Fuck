package com.homework.h1;

import com.homework.wenjian.Line;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Score {

    public static void show(long time, String name) throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/insert?username=" + "" + "&score=" + time);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        byte[] by = new byte[1024 * 1024 * 1000];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(by)) != -1) {
            sb.append(new String(by, 0, len));
            System.out.println(sb);
            sb.setLength(0);

        }
    }
}

