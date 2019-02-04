package com.zhutao.aop.service.impl;

import com.zhutao.aop.service.HelloService;

import java.util.Objects;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:36
 * @Version 1.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())){
            throw new RuntimeException("param is null");
        }
        System.out.println("Hello " + name);
    }
}
