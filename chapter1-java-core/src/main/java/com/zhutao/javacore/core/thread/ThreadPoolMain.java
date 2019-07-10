package com.zhutao.javacore.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhutao
 * @Date: 2019/2/19 15:59
 * @Version 1.0
 */
public class ThreadPoolMain {

    private static boolean done = false;

    private static volatile boolean volatileDone = false;

    public static void main(String[] args){
//        createThreadPool();

        testNonVolatile();
    }


    /**
     * 主要有三种 Executor：
     *
     * CachedThreadPool：一个任务创建一个线程；
     * FixedThreadPool：所有任务只能使用固定大小的线程；
     * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
     */
    public static void createThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<10; i++){
            executorService.execute(() -> {
                System.out.println("newCachedThreadPool ");
            });
        }

        executorService.shutdown();
    }

    // 当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程
    public static void daemon(){
        Thread thread = new Thread(() -> System.out.println("test daemon"));

        // 设置为后台守护进程
        thread.setDaemon(true);
    }

    public static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testNonVolatile(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i< 1000; i++){
                System.out.println(i);
            }
            done = true;
        });

        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (!done) i++;
            System.out.println("goodBye " + i);
        });

        ExecutorService executorService =Executors.newCachedThreadPool();

        executorService.execute(thread);

        executorService.execute(thread1);
    }

}
