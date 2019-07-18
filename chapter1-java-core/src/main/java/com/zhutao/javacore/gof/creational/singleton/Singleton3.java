package com.zhutao.javacore.gof.creational.singleton;

/**
 * 懒汉式 线程安全
 * 使用synchronized实现线程安全
 * 性能一般 如果实例化过程较慢,易出问题
 *
 * @Author: zhutao
 * @Date: 2019-06-24 20:15
 * @Version 1.0
 */
public class Singleton3 {
    private static Singleton3 singleton;

    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (singleton == null) {
            singleton = new Singleton3();
            return singleton;
        }
        return singleton;
    }
}
