package com.zhutao.learn.core.javacore.gof.behavior.template;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 20:31
 * @Version 1.0
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("boilWater");
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }
}
