package com.zhutao.learn.core.javacore.concurrence.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhutao
 * @Date: 2019-07-10 20:51
 * @Version 1.0
 */
public class ThreadSafeMain {
    public static void main(String[] args) {
        testVolatile();
    }

    private static volatile boolean done = false;

    private static ExecutorService executor = Executors.newFixedThreadPool(8);
    /**
     * 内存三大模型之可见性
     * 可见性指当一个线程修改了共享变量,其他线程能立即得知修改
     *
     * 不可见原因:
     * 1. 缓存 cpu速度远大于内度速度,cpu缓存未更新导致
     * 2. 指令重排
     * 编译器,虚拟机可能改变指令的顺序以加速操作(在自己认为不会影响程序的情况下)
     * 在此栗子中, while (!done) i++ 会被重排序成 if (!done) while (true) i++; 因为循环体内没有改变done值
     *
     *
     *
     * 默认情况下,虚拟机不会考虑并发内存访问,需要显式指定变量,阻止指令重排序
     * 确保变量可见性的方式
     * 1. final变量在初始化后是可见的
     * 2. static变量在静态初始化后是可见的
     * 3. 对volatile变量的改变是可见的(最常用)
     * 4. 锁释放前的改变对任何试图获取当前锁的所有人是可见的
     */
    private static void testVolatile() {
        Runnable hellos = () -> {
            for (int i=0; i<1000;i++) {
                System.out.println("hello " +i);
            }
            done = true;
        };

        Runnable goodbye = () -> {
            int i = 1;
            while (!done) i++;
            System.out.println("bye " + i);
        };
        executor.execute(hellos);

        executor.execute(goodbye);
    }

}
