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
        int count = 2000;
        for (int i = 0; i<count;i++){
            send("message" + i);
        }
    }

    public static void send(String message) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        out.write(message.getBytes());
        out.close();
    }
}
