package com.zhutao.controller;

import com.zhutao.pojo.User;
import com.zhutao.rabbitmq.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhutao
 * @Date: 2019/2/26 15:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private RabbitmqService rabbitmqService = null;

    @GetMapping("/msg")
    public Map<String, Object> msg(String msg){
        rabbitmqService.sendMsg(msg);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }

    @GetMapping("/user")
    public Map<String, Object> user(){
        User user = new User("zhu", 11, "note_1");
        rabbitmqService.sendUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return map;
    }

}
