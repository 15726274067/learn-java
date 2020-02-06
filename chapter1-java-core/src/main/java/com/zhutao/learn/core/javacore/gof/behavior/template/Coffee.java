package com.zhutao.learn.core.javacore.gof.behavior.template;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 20:33
 * @Version 1.0
 */
public class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
