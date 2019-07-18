package com.zhutao.javacore.gof.creational.singleton;

/**
 * 单例模式: 私有的构造函数 + 静态方法返回单例对象
 *
 * 懒汉式 线程不安全
 * 不安全原因:
 * 多线程下存在竞争条件导致同时进入 if 代码块内,会初始化多个单例对象
 *
 * @Author: zhutao
 * @Date: 2019-06-24 20:09
 * @Version 1.0
 */
public class Singleton1 {
    private static Singleton1 singleton;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
            return singleton;
        }
        return singleton;
    }
}
