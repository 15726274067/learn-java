package com.zhutao.learn.mq.rabbitmq.exchange.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhutao.learn.mq.rabbitmq.simple.RabbitmqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:00
 * @Version 1.0
 */
public class Producer {
    private final static String DIRECT_EXCHANGE = "direct_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机,这里不需要声明队列
        channel.exchangeDeclare(DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);

        String msg = "hello rabbitmq";
        // 发送到交换机
        channel.basicPublish(DIRECT_EXCHANGE, "insert", null, msg.getBytes());
        System.out.println("生产者: 数据发送成功");
        channel.close();
        connection.close();
    }
}
