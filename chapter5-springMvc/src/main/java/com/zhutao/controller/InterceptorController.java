package com.zhutao.controller;

import com.zhutao.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhutao
 * @Date: 2019/2/21 14:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/start")
    public String start(){
        System.out.println("执行处理器逻辑");
        throw new CustomException(501L, "interceptor error");
//        return "welcome";
    }

    @GetMapping("/header")
    public Map<String, Object> getHeader(@RequestHeader("id") String id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return map;
    }
}
