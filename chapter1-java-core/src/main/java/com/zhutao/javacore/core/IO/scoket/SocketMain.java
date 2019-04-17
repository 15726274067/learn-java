package com.zhutao.javacore.core.IO.scoket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * @Author: zhutao
 * @Date: 2019/2/19 10:26
 * @Version 1.0
 */
public class SocketMain {
    public static void main(String[] args){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            URL url = new URL("http://www.baidu.com");

            /* 字节流 */
            InputStream is = url.openStream();

            /* 字符流 */
            InputStreamReader isr = new InputStreamReader(is, "utf-8");

            /* 提供缓存功能 */
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
