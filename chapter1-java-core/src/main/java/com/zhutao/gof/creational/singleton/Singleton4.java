package com.zhutao.gof.creational.singleton;

/**
 * 双重校验锁-线程安全
 *
 * 单例只需要被实例化一次，之后就可以直接使用了。
 * 加锁操作只需要对实例化那部分的代码进行，只有当 对象 没有被实例化时，才需要进行加锁
 * 双重校验锁先判断 对象 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁
 *
 * 为什么要有双重检校?
 * 两个线程同时进入if 内部,即使存在锁,也会初始化两次对象, 因此需要在对象初始化前再次判断是否为null
 *
 *
 * 为什么采用 volatile 关键字?
 * singleton = new Singleton(); 这段代码其实是分为三步执行：

 * 1. 为 singleton 分配内存空间
 * 2. 初始化 singleton
 * 3. 将 singleton 指向分配的内存地址
 * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，
 * 但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，
 * 因此返回 singleton，但此时 singleton 还未被初始化。
 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 * @Author: zhutao
 * @Date: 2019-06-24 20:20
 * @Version 1.0
 */
public class Singleton4 {
    private volatile static Singleton4 singleton;

    private Singleton4() {

    }

    public static  Singleton4 getInstance() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}
