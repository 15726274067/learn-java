package com.zhutao.rabbitmq.service.impl;

import com.zhutao.pojo.User;
import com.zhutao.rabbitmq.service.RabbitmqService;
import org.springframework.amqp.core.Message;
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
        rabbitTemplate.convertAndSend(msgRouting, msg);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送用户消息 user: " + user.toString());
        rabbitTemplate.setConfirmCallback(this);

        rabbitTemplate.convertAndSend(userRouting, user);
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
            System.out.println("消息消费成功: " );
        } else {
            System.out.println("消息消费失败: " + cause);
        }
    }
}
