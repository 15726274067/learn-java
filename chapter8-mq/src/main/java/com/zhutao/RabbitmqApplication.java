package com.zhutao;

import com.zhutao.rabbitmq.service.RabbitmqService;
import com.zhutao.rabbitmq.service.impl.RabbitmqServiceImpl;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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

    @Value("${rabbitmq.queue.ack}")
    private String ackQueueName;
    @Bean
    public Queue createQueueMsg(){
        // 创建字符串消息, boolean值代表是否持久化消息
        // SpringBoot的机制会自动注册这两个队列
        return new Queue(msgQueueName, true, false, false);
    }

    /**
     * 需要手动确认的消息
     * @return
     */
    @Bean
    public Queue createAckQueue(){
        return new Queue(ackQueueName, true, false, false);
    }

    @Bean
    public TopicExchange createTopicExchange() {
        // 创建交换器
        return new TopicExchange("exchange1", true, true);
    }

    @Bean
    public Queue creteQueueUser(){
        return new Queue(userQueueName, true, false, false);
    }

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(RabbitmqApplication.class);
        RabbitmqService service = context.getBean(RabbitmqServiceImpl.class);
        int count = 10;
        for (int i=0; i< count; i++) {
//            service.sendMsg("aaa" + i);
            service.sendAckMsg("aaa" + i);
        }
    }
}
