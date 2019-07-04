package com.zhutao.gof.creational.abstractfactory;

/**
 * @Author: zhutao
 * @Date: 2019-06-29 22:10
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        // do something with productA and productB
    }
}

