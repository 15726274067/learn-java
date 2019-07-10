package com.zhutao.javacore.core.io.bio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(new InputStreamReader(socket.getInputStream()));

            if ( scanner.hasNext()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
            writer = new PrintWriter(socket.getOutputStream());
            writer.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    System.out.println("连接关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
