package com.zhutao.learn.spring.ioc.service.impl;

import com.zhutao.learn.spring.ioc.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 18:27
 * @Version 1.0
 */
@Service
public class UserService {
    public User getById(){
        return new User(1L, "zhutao", "note_1");
    }
}
