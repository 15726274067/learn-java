package com.zhutao.javacore.core.io.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: zhutao
 * @Date: 2019-07-04 15:37
 * @Version 1.0
 */
public class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reader.lines().forEach(x -> System.out.println("接收到的: " + x));

            writer = new PrintWriter(socket.getOutputStream());
            writer.println("hello");
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
                System.out.println("连接关闭");
            }
        }
    }
}
