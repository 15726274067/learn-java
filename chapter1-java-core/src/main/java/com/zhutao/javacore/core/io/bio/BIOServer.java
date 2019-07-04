package com.zhutao.javacore.core.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhutao
 * @Date: 2019-07-04 15:23
 * @Version 1.0
 */
public class BIOServer extends Thread {

    private ServerSocket serverSocket;

    private ExecutorService executors;
    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(7801);
            executors = Executors.newFixedThreadPool(4);
            System.out.println("server 创建成功");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新的连接建立");

                RequestHandler handler = new RequestHandler(socket);
                executors.execute(handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BIOServer bioServer = new BIOServer();
        bioServer.start();
    }
}
