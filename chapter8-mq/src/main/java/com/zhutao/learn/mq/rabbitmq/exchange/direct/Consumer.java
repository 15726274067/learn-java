package com.zhutao.learn.mq.rabbitmq.exchange.direct;

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
    private final static String DIRECT_EXCHANGE = "direct_exchange";
    private final static String DIRECT_EXCHANGE_QUEUE1 = "direct_exchange_queue1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = RabbitmqConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列,重复声明会忽略
        channel.queueDeclare(DIRECT_EXCHANGE_QUEUE1, false, false, false, null);

        // 绑定队列到交换机
        // 使用direct模式
        // 表示此队列关心direct_exchange交换机上发生的insert/delete事件
        channel.queueBind(DIRECT_EXCHANGE_QUEUE1, DIRECT_EXCHANGE, "insert");
        channel.queueBind(DIRECT_EXCHANGE_QUEUE1, DIRECT_EXCHANGE, "delete");

        channel.basicQos(1);
        // 创建消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg =new String(body);
                System.out.println("消费者1收到消息: " + msg);
                // 拒绝消息, 会重新进队列
                // 需要保证消费的幂等
                channel.basicNack(envelope.getDeliveryTag(), false, true);
            }
        };

        // 消费者绑定到监听队列上
        // autoAck: 是否进行自动确认
        channel.basicConsume(DIRECT_EXCHANGE_QUEUE1, true, consumer);
    }
}
