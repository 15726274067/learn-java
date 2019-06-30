package com.zhutao.gof.structural.flyweight;

/**
 * @Author: zhutao
 * @Date: 2019-06-30 17:26
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        flyweight1.doOperation("x");
        flyweight2.doOperation("y");
    }
}

