package com.zhutao.learn.mq.rabbitmq.exchange.fanout;

import com.rabbitmq.client.*;
import com.zhutao.learn.mq.rabbitmq.simple.RabbitmqConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:01
 * @Version 1.0
 */
public class Consumer {
    private final static String SIMPLE_QUEUE = "simple_queue";
    private final static String FANOUT_EXCHANGE = "fanout_exchange";
    private final static String FANOUT_EXCHANGE_QUEUE1 = "fanout_exchange_queue1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitmqConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列,重复声明会忽略
        // 队列的持久化
        channel.queueDeclare(FANOUT_EXCHANGE_QUEUE1, true, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(FANOUT_EXCHANGE_QUEUE1, FANOUT_EXCHANGE, "");

        channel.basicQos(1);
        // 创建消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg =new String(body);
                System.out.println("消费者1收到消息: " + msg);
            }
        };

        // 消费者绑定到监听队列上
        // autoAck: 是否进行自动确认
        channel.basicConsume(SIMPLE_QUEUE, true, consumer);
    }
}
