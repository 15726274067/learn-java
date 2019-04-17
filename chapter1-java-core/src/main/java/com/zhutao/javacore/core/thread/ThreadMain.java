package com.zhutao.javacore.core.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: zhutao
 * @Date: 2019/2/19 15:45
 * @Version 1.0
 */
public class ThreadMain {
    public static void main(String[] args){
//        createThread();

        createFutureTask();
    }

    public static void createThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("create new thread");
            }
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("new thread with lambda");
        });

        thread.start();

        thread1.start();
    }

    public static void createFutureTask() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

        Thread thread = new Thread(futureTask);

        thread.start();

        // false
        System.out.println("isDone: " +futureTask.isDone());
        try {
            // 1
            System.out.println("get result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // true
        System.out.println("isDone: " +futureTask.isDone());
    }
}
