package com.zhutao.rabbitmq.exchange.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhutao.rabbitmq.simple.RabbitmqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:00
 * @Version 1.0
 */
public class Producer {
    private final static String SIMPLE_QUEUE = "simple_queue";
    private final static String FANOUT_EXCHANGE = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机,这里不需要声明队列
        channel.exchangeDeclare(FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);

        String msg = "hello rabbitmq";
        // 发送到交换机
        channel.basicPublish(FANOUT_EXCHANGE, "", null, msg.getBytes());
        System.out.println("生产者: 数据发送成功");
        channel.close();
        connection.close();
    }
}
