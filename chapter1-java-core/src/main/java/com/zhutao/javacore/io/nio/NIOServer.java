package com.zhutao.javacore.io.nio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: zhutao
 * @Date: 2019/7/31 22:16
 * @Version 1.0
 */
public class NIOServer extends Thread {

    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();

            channel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 10888));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socket = server.accept();

                    ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
                    int read = socket.read(buffer);

                    System.out.println("server receive: " + buffer.toString());

                    socket.write(Charset.defaultCharset().encode("hello nio"));
                    System.out.println("server send: " + "hello nio");
                    socket.close();
                    iterator.remove();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NIOServer server = new NIOServer();
        server.start();
    }
}
