package com.zhutao.learn.spring.aop.validator.impl;

import com.zhutao.learn.spring.aop.validator.HelloValidator;

/**
 * 引入
 * 对方法功能进行增强
 * @Author: zhutao
 * @Date: 2019/2/11 19:04
 * @Version 1.0
 */
public class HelloValidatorImpl implements HelloValidator {
    @Override
    public boolean valid(String name) {
        System.out.println("引入新的接口: " + this.getClass().getName());
        return name != null;
    }
}
