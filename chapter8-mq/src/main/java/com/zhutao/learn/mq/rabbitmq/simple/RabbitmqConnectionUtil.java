package com.zhutao.learn.mq.rabbitmq.simple;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.DefaultCredentialsProvider;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zhutao
 * @Date: 2019/8/21 23:01
 * @Version 1.0
 */
public class RabbitmqConnectionUtil {
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);

        // 一定要这个才能自动恢复
        connectionFactory.setCredentialsProvider(new DefaultCredentialsProvider("", ""));
        connectionFactory.setAutomaticRecoveryEnabled(true);
        return connectionFactory.newConnection();
    }
}
