package com.zhutao.learn.core.javacore.gof.creational.abstractfactory;

/**
 * @Author: zhutao
 * @Date: 2019-06-29 22:09
 * @Version 1.0
 */
public class ConcreteFactory1 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
