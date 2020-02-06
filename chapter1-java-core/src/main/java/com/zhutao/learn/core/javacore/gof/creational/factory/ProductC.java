package com.zhutao.learn.core.javacore.gof.creational.factory;

/**
 * @Author: zhutao
 * @Date: 2019-06-24 20:40
 * @Version 1.0
 */
public class ProductC implements Product {
    @Override
    public String showName() {
        return this.getClass().getSimpleName();
    }
}
