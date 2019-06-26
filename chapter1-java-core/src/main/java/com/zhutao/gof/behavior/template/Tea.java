package com.zhutao.gof.behavior.template;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 20:33
 * @Version 1.0
 */
public class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}