package com.zhutao.rabbitmq.service;

import com.zhutao.pojo.User;

/**
 * @Author: zhutao
 * @Date: 2019/2/26 15:28
 * @Version 1.0
 */
public interface RabbitmqService {
    void sendMsg(String msg);

    void sendUser(User user);

    void sendAckMsg(String msg);
}
