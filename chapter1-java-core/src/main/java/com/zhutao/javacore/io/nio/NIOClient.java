package com.zhutao.javacore.io.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

/**
 * @Author: zhutao
 * @Date: 2019/2/18 18:54
 * @Version 1.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        int count = 2000;
        for (int i = 0; i<count;i++){
            send("message" + i);
        }
    }

    public static void send(String message) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 10888);
        OutputStream out = socket.getOutputStream();
        out.write(message.getBytes());
        System.out.println("client send: " + message);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1000];
        while (inputStream.read(bytes) > 0) {

        }

        System.out.println("client receive: " + new String(bytes));
        socket.close();
    }
}
