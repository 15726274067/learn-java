package com.zhutao.rabbitmq.receiver;

import com.zhutao.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbitmq 消费者
 * @Author: zhutao
 * @Date: 2019/2/26 15:53
 * @Version 1.0
 */
@Component
public class RabbitMessageReceiver {

    /**
     * 定义监听字符串队列名称
     * @param msg
     */
    @RabbitListener(queues = { "${rabbitmq.queue.msg}" })
    public void receiveMsg(String msg){
        System.out.println("收到消息 :" + msg);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveUser(User user){
        System.out.println("收到用户消息 :" + user.toString());
    }
}
