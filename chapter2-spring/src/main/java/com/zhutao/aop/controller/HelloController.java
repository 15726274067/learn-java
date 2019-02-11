package com.zhutao.aop.controller;

import com.zhutao.aop.service.HelloService;
import com.zhutao.aop.validator.HelloValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 18:39
 * @Version 1.0
 */
@Controller
@RequestMapping("/aop")
public class HelloController {

    @Autowired
    private HelloService helloService = null;

    @GetMapping("/print")
    @ResponseBody
    public HashMap<String, String> print(String name){
        /**
         * 使用aop的增强功能, 需要强制转换下
         * 原理:
         * newProxyInstance 的第二个参数为一个对象数组, 也就是说这里生产代理对象时, Spring
         * 会把 HelloService 和 HelloValidator 两个接口传递进去,让代理对象下挂到这两个接口下,
         * 这样这个代理对象就能够相互转换并且使用它们的方法了
         */
        HelloValidator helloValidator = (HelloValidator) helloService;
        if (!helloValidator.valid(name)){
            System.out.println("name is null");
            return null;
        }
        helloService.print(name);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", name);
        return hashMap;
    }

    @GetMapping("/aspects")
    @ResponseBody
    public String manyAspects(){
        helloService.manyAspects();
        return "Aspect";
    }
}
