package com.zhutao.javacore.core.io.bio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: zhutao
 * @Date: 2019-07-04 15:56
 * @Version 1.0
 */
public class BIOClient {

    public static void run() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 7801);
            String random = String.valueOf(Math.random());
//            OutputStream outputStream = socket.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reader.lines().forEach(x -> System.out.println("相应: "+ x));

//            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i<10; i++) {
            BIOClient.run();
        }
    }
}
