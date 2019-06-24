package com.zhutao.gof.singleton;

/**
 * 饿汉式 线程安全
 * 但是不是延迟加载
 * @Author: zhutao
 * @Date: 2019-06-24 20:13
 * @Version 1.0
 */
public class Singleton2 {
    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {

    }
    public static Singleton2 getInstance() {
        return singleton;
    }
}
