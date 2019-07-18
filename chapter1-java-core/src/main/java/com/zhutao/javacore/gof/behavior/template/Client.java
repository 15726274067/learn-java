package com.zhutao.javacore.gof.behavior.template;

/**
 * @Author: zhutao
 * @Date: 2019-06-26 20:35
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("-----------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();
    }
}
