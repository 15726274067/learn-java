package com.zhutao;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @Author: zhutao
 * @Date: 2019/2/26 15:19
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zhutao")
public class RabbitmqApplication {

    /**
     * 创建rabbitmq队列
     *
     */
    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName = null;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName = null;

    @Bean
    public Queue createQueueMsg(){
        // 创建字符串消息, boolean值代表是否持久化消息
        return new Queue(msgQueueName, true);
    }

    @Bean
    public Queue creteQueueUser(){
        return new Queue(userQueueName, true);
    }

    public static void main(String[] args){
        SpringApplication.run(RabbitmqApplication.class);
    }
}
