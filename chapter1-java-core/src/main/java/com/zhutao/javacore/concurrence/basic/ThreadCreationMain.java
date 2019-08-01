package com.zhutao.javacore.concurrence.basic;

import java.util.concurrent.*;

/**
 * 线程的状态转换以及基本操作
 * @Author: zhutao
 * @Date: 2019/2/19 15:45
 * @Version 1.0
 */
public class ThreadCreationMain {
    public static void main(String[] args){
//        createThread();
//        createFutureTask();
//        deadLock();

        createThread2();
    }

    public static void createThread(){
        Thread thread = new Thread(() -> System.out.println("create new thread"));

        Thread thread1 = new Thread(() -> System.out.println("new thread with lambda"));

        thread.start();

        thread1.start();
    }

    /**
     * 创建线程的三种方式
     */
    private static void createThread2() {
        //1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread.start();

        //2.实现runable接口
        Thread thread1 = new Thread(() -> System.out.println("实现runable接口"));
        thread1.start();

        //3.实现callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit((Callable) () -> "通过实现Callable接口");
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void createFutureTask() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1);

        Thread thread = new Thread(futureTask);

        thread.start();

        // false
        System.out.println("isDone: " +futureTask.isDone());
        try {
            // 1
            System.out.println("get result: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // true
        System.out.println("isDone: " +futureTask.isDone());
    }

    private static final String resourceA = "resourceA";

    private static final String resourceB = "resourceB";

    /**
     * 死锁 访问临界资源
     * 原因
     * 互斥：每个资源要么已经分配给了一个进程，要么就是可用的。
     * 占有和等待：已经得到了某个资源的进程可以再请求新的资源。
     * 不可抢占：已经分配给一个进程的资源不能强制性地被抢占，它只能被占有它的进程显式地释放。
     * 环路等待：有两个或者两个以上的进程组成一条环路，该环路中的每个进程都在等待下一个进程所占有的资源
     *
     * 避免死锁的情况：
     *
     * 避免一个线程同时获得多个锁；
     * 避免一个线程在锁内部占有多个资源，尽量保证每个锁只占用一个资源；
     * 尝试使用定时锁，使用lock.tryLock(timeOut)，当超时等待时当前线程不会阻塞；
     * 对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况
     *
     */
    public static void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadA get resourceA");
                synchronized (resourceB) {
                    System.out.println("threadA get resourceB");
                }
            }
        });

        threadA.setPriority(10);

        Thread threadB = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("threadB get resourceB");
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA");
                }
            }
        });

        threadA.start();

        threadB.start();
    }
}
