package com.zhutao.javacore.concurrence.basic;

/**
 * 当有线程t1,t2,t3,如何实现t1->t2->t3的执行顺序
 * @Author: zhutao
 * @Date: 2019/7/20 13:21
 * @Version 1.0
 */
public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
//        threadSync2();
//        threadSync3();
        threadSync4();
    }


    /**
     * 无法保证线程同步
     */
    public static void threadSyncFail() throws InterruptedException {
        Thread t1 = new Thread( () -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> System.out.println("t2"));
        Thread t3 = new Thread(() -> System.out.println("t3"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    /**
     * 保证线程同步
     * @throws InterruptedException
     */
    public static void threadSync1() throws InterruptedException {
        Thread t1 = new Thread( () -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> System.out.println("t2"));
        Thread t3 = new Thread(() -> System.out.println("t3"));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    /**
     * 第二种保证顺序执行的方式
     */
    public static void threadSync2() throws InterruptedException {
        Thread t1 = new Thread( () -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> System.out.println("t2"));
        Thread t3 = new Thread(() -> System.out.println("t3"));

        t1.start();
        while (t1.isAlive()) {
            Thread.sleep(0);
        }

        t2.start();
        while (t2.isAlive()) {
            Thread.sleep(0);
        }

        t3.start();
    }

    /**
     * 第3种保证顺序执行的方式(自旋,不会让出cpu时间片)
     */
    public static void threadSync3() throws InterruptedException {
        Thread t1 = new Thread( () -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> System.out.println("t2"));
        Thread t3 = new Thread(() -> System.out.println("t3"));

        t1.start();
        while (t1.isAlive()) {
            Thread.sleep(0);
        }

        t2.start();
        while (t2.isAlive()) {
            Thread.sleep(0);
        }

        t3.start();
    }


    /**
     * 实现Thread::join
     *
     * join() 的核心实现
     *  while (isAlive()) {
     *      wait(0);
     *  }
     */

    public static void doWait(Thread thread) throws InterruptedException {
        while (thread.isAlive()) {
            synchronized (thread) {
                thread.wait(0);
            }
        }
    }

    public static void threadSync4() throws InterruptedException {
        Thread t1 = new Thread( () -> {
            System.out.println("t1");
        });
        t1.start();
        doWait(t1);

        Thread t2 = new Thread(() -> System.out.println("t2"));
        t2.start();
        doWait(t2);

        Thread t3 = new Thread(() -> System.out.println("t3"));
        t3.start();

    }

}
