package com.zhutao.learn.redis.controller;

import com.zhutao.learn.redis.pojo.User;
import com.zhutao.learn.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhutao
 * @Date: 2019/2/15 9:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/redis/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("result", user);
        return map;
    }

    @PostMapping()
    public HashMap<String, Object> insertUser(@RequestBody User user){
        User result = userService.insertUser(user);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

    @PutMapping()
    public HashMap<String, Object> updateUser(@RequestBody User user){
        User result = userService.updateUserName(user.getId(), user.getUserName());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Object> removeUser(@PathVariable Long id){
        int result = userService.deleteUser(id);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

}
