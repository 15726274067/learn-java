package com.zhutao.learn.mq.rabbitmq.service.impl;

import com.zhutao.learn.mq.pojo.User;
import com.zhutao.learn.mq.rabbitmq.service.RabbitmqService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Author: zhutao
 * @Date: 2019/2/26 15:30
 * @Version 1.0
 */
@Service
public class RabbitmqServiceImpl implements RabbitmqService, RabbitTemplate.ConfirmCallback {

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting = null;

    @Value("${rabbitmq.queue.user}")
    private String userRouting = null;

    @Value("${rabbitmq.queue.ack}")
    private String ackQueueName;
    /**
     * 注入由springboot自动配置的rabbit template
     */
    @Autowired
    private RabbitTemplate rabbitTemplate = null;

    @Override
    public void sendMsg(String msg) {
        System.out.println("发送消息 msg: " + msg);
        // 设置回调
        rabbitTemplate.setConfirmCallback(this);
        // 转换并发送消息
        rabbitTemplate.convertAndSend("fanout_exchange" ,msgRouting, msg);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送用户消息 user: " + user.toString());
        rabbitTemplate.setConfirmCallback(this);

        rabbitTemplate.convertAndSend(userRouting, user);
    }


    public void sendAckMsg(String msg) {
        System.out.println("发送ack消息 msg: " + msg);
        rabbitTemplate.setConfirmCallback(this);
        // 转换并发送消息
        // 发送时需要给出唯一的标识(CorrelationData)
        rabbitTemplate.convertAndSend("", ackQueueName, msg, new CorrelationData(Math.random() + ""));
    }

    /**
     * 回调确认方法
     * @param correlationData
     * @param ack 消息是否被成功消费
     * @param cause 消息消费失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            String id = correlationData==null? "": correlationData.getId();
            System.out.println("消息投递成功 id: " + id);

        } else {
            System.out.println("消息投递失败" + cause);
        }
    }
}
