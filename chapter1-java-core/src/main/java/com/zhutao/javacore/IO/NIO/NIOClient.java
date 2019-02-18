package com.zhutao.javacore.IO.NIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: zhutao
 * @Date: 2019/2/18 18:54
 * @Version 1.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        int count = 10000;
        for (int i = 0; i<count;i++){
            send();
        }
    }

    public static void send() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
