package com.zhutao.service;

import com.zhutao.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 18:27
 * @Version 1.0
 */
@Service
public class UserService {
    public User getById(){
        return new User(1L, "zhurao", "note_1");
    }
}
