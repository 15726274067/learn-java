package com.zhutao.service;

/**
 * @Author: zhutao
 * @Date: 2019/2/15 23:32
 * @Version 1.0
 */
public interface JmsService {
    void sendMsg(String message);

    void receiveMsg(String message);
}
