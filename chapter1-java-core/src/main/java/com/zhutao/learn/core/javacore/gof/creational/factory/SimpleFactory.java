package com.zhutao.learn.core.javacore.gof.creational.factory;

/**
 * 工厂模式
 * 1. 简单工厂
 * 2. 工厂方法
 * 3. 抽象工厂
 *
 * 简单工厂
 * 实例化操作放入简单工厂类,对外封装对象创建的过程
 * @Author: zhutao
 * @Date: 2019-06-24 20:33
 * @Version 1.0
 */
public class SimpleFactory {
    public Product getProduct(int type) {
        if (type == 1) {
            return new ProductA();
        } else if (type == 2) {
            return new ProductB();
        }
        return new ProductC();
    }
}

