package com.zhutao.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听器
 * @Author: zhutao
 * @Date: 2019/2/14 21:57
 * @Version 1.0
 */
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 消息体
        String body = new String(message.getBody());

        // topic名称
        String topic = new String(pattern);

        System.out.println(" body: " + body + "\n topic: " + topic);
    }

}
