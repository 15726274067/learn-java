package com.zhutao.learn.spring.aop.service;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:34
 * @Version 1.0
 */
public interface HelloService {
    public void sayHello(String name);

    public void print(String name);

    void manyAspects();
}
