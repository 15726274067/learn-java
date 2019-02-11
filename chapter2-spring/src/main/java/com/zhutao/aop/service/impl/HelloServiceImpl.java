package com.zhutao.aop.service.impl;

import com.zhutao.aop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:36
 * @Version 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())){
            throw new RuntimeException("param is null");
        }
        System.out.println("Hello " + name);
    }

    @Override
    public void print(String name) {
        if (name == null || "".equals(name.trim())){
            throw new RuntimeException("param is null");
        }
        System.out.println("print: " + name);
    }

    public void manyAspects(){
        System.out.println("多个切面...");
    }
}
