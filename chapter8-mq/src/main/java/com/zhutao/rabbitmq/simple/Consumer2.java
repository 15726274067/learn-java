package com.zhutao.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:01
 * @Version 1.0
 */
public class Consumer2 {
    private final static String SIMPLE_QUEUE = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitmqConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列,重复声明会忽略
        channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
        // 设置每个消费者只会预取一条消息,这样就会根据消费者的消费能力来决定消费消息的个数
        channel.basicQos(1);
        // 创建消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg =new String(body);
                System.out.println("收到消息: " + msg);
                // 手动确认消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // 消费者绑定到监听队列上
        // autoAck: 是否进行自动确认
        channel.basicConsume(SIMPLE_QUEUE, false, consumer);
    }
}
