package com.zhutao.javacore.concurrence.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhutao
 * @Date: 2019-07-18 20:51
 * @Version 1.0
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock= new ReentrantLock();
        reentrantLock.lock();
    }
}
