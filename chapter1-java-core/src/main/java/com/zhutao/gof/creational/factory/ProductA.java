package com.zhutao.gof.creational.factory;

/**
 * @Author: zhutao
 * @Date: 2019-06-24 20:40
 * @Version 1.0
 */
public class ProductA implements Product {
    @Override
    public String showName() {
        return this.getClass().getSimpleName();
    }
}
