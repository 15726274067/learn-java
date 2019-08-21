package com.zhutao.rabbitmq.exchange.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
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

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机,这里不需要声明队列
        // 交换机的持久化
        channel.exchangeDeclare(FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT, true);

        // 开启生产者确认
        channel.confirmSelect();
        String msg = "hello rabbitmq";
        // 发送到交换机
        // 消息的持久化
        channel.basicPublish(FANOUT_EXCHANGE, "", MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        System.out.println("生产者: 数据发送成功");

        // 生产者确认机制,交换机收到消息,回调生产者
        channel.waitForConfirmsOrDie(1000);
        channel.close();
        connection.close();
    }
}
