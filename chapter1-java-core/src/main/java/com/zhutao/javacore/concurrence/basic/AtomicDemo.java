package com.zhutao.javacore.concurrence.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 内存模型三大特性之-- 原子性
 * @Author: zhutao
 * @Date: 2019-07-11 20:31
 * @Version 1.0
 */
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
