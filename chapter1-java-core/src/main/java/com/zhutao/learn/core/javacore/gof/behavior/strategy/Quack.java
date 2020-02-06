package com.zhutao.learn.core.javacore.gof.behavior.strategy;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 21:37
 * @Version 1.0
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
