package com.zhutao.gof.behavior.strategy;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 21:37
 * @Version 1.0
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
