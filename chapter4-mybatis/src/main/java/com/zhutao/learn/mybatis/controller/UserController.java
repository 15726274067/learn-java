package com.zhutao.learn.mybatis.controller;

import com.zhutao.learn.mybatis.common.enumation.SexEnum;
import com.zhutao.learn.mybatis.pojo.User;
import com.zhutao.learn.mybatis.pojo.vo.UserQueryVO;
import com.zhutao.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/username")
    public HashMap<String, Object> getUserByName(String name){
        List<User> users = userService.getUserByName(name);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", users);
        hashMap.put("count", users.size());
        return hashMap;
    }

    /**
     * 传递数组
     * ?ids=1,2,3
     * @param ids
     * @return
     */
    @GetMapping("/user/id")
    public HashMap<String, Object> getListById(Long[] ids){
        List<Long> list = Arrays.asList(ids);
        List<User> users = userService.getListById(list);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", users);
        return hashMap;
    }

    @GetMapping("/user/query")
    public HashMap<String, Object> getListByQuery(Long id, String name, String sex, String note, Integer page, Integer size){
        User user = new User();
        user.setId(id);
        user.setNote(note);
        user.setUserName(name);
        if (sex != null) user.setSex(SexEnum.valueOf(sex));

        UserQueryVO userQueryVO = new UserQueryVO(user);
        if(page != null) userQueryVO.setPage(page);
        if(size != null) userQueryVO.setSize(size);
        List<User> users = userService.getListByQuery(userQueryVO);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", users);
        return hashMap;
    }

    @PostMapping("/user")
    public HashMap<String, Object> insertUser(@RequestBody User user){
        int result = userService.insertUser(user);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

    @PostMapping("/user/batch")
    public HashMap<String, Object> insertUser(@RequestBody List<User> users){
        int result = userService.insertBatch(users);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

    @PutMapping("/user")
    public HashMap<String, Object> updateUser(@RequestBody User user){
        int result = userService.updateUser(user);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

    @DeleteMapping("/user")
    public HashMap<String, Object> removeUser(Long id){
        int result = userService.removeUser(id);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", result);
        return hashMap;
    }

}
