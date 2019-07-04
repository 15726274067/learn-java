package com.zhutao.gof.creational.abstractfactory;

/**
 * @Author: zhutao
 * @Date: 2019-06-29 22:09
 * @Version 1.0
 */
public class ConcreteFactory2 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    AbstractProductB createProductB() {
        return new ProductB2();
    }
}

