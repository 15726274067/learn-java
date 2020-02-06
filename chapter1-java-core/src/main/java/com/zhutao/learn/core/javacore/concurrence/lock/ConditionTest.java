package com.zhutao.learn.core.javacore.concurrence.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

/**
 * 使用condition实现三个线程,轮流打印a,b,c
 * @Author: zhutao
 * @Date: 2019-09-16 14:51
 * @Version 1.0
 */
public class ConditionTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            while (true) {
                System.out.println("a");
            }
//            while (!lock.hasWaiters(conditionA)) {
//                System.out.println("a");
//                try {
//                    conditionA.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        });

        threadPool.execute(() -> {
//            lock.lock();
//            try {
//                conditionB.await();
//                conditionC.signalAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
            while (true) {
                System.out.println("b");
            }
        });

        threadPool.execute(() -> {

//            try {
//                lock.lock();
//                conditionC.await();
//                System.out.println("c");
//                conditionA.signalAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }

        });
    }
}
