package com.zhutao.gof.behavior.strategy;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 21:38
 * @Version 1.0
 */public class Duck {

    private QuackBehavior quackBehavior;

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
