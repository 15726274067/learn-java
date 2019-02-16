package com.zhutao.service.impl;

import com.zhutao.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @Author: zhutao
 * @Date: 2019/2/15 23:33
 * @Version 1.0
 */
public class JmsServiceImpl implements JmsService {

    @Autowired
//    private Jmstemplate jmstemplate = null;

    @Override
    public void sendMsg(String message) {

    }

    @Override
    public void receiveMsg(String message) {

    }
}
