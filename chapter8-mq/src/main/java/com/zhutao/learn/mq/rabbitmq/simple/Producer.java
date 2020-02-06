package com.zhutao.learn.mq.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:00
 * @Version 1.0
 */
public class Producer {
    private final static String SIMPLE_QUEUE = "simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);

        String msg = "hello rabbitmq";
        channel.basicPublish("", SIMPLE_QUEUE, null, msg.getBytes());
        System.out.println("数据发送成功");
        channel.close();
        connection.close();
    }
}
