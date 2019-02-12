package com.zhutao.controller;

import com.zhutao.pojo.User;
import com.zhutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 14:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/mybatis")
public class UserController {

    @Autowired
    private UserService userService = null;

    @GetMapping("/user")
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @GetMapping("/user2")
    public User getUser2(Long id){
        return userService.getUser2(id);
    }
}
