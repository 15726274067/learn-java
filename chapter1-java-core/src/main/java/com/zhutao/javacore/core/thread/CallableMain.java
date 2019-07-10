package com.zhutao.javacore.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Callable && Future
 *
 * @Author: zhutao
 * @Date: 2019-07-10 20:15
 * @Version 1.0
 */
public class CallableMain {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
//        testTask();

        testCancleTask();
    }

    public static void testTask() {
        // 获取可用处理器数目
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors: " + availableProcessors);

        Callable<String> task = () -> {
            return "hahaha";
        };

        Callable<String> taskThrowErr = () -> {
            throw new RuntimeException("aaaaa");
        };

        Future<String> future = threadPool.submit(task);

        Future<String> future1 = threadPool.submit(taskThrowErr);
        System.out.println("isDone: " + future.isDone());
        String s = null;
        try {
            // get 会阻塞,直到获取结果或者超时
            s = future.get();

            future1.get();
        } catch (InterruptedException | ExecutionException e) {
            // 执行阶段可能会抛出 ExecutionException,这个异常包装了真实的异常
            // 需要调用e.getCause() 获取真实异常
            e.getCause().printStackTrace();
        }
        System.out.println("isDone: " + future.isDone());

        System.out.println(s);
    }
    public static void testCancleTask() {
        Callable<String> task = () -> {
            Thread.sleep(3000);
            return "success";
        };

        Future<String> future = threadPool.submit(task);
        try {
            /**
             * cancel 试图取消任务, 如果任务未执行,会直接取消
             * 任务已执行, 会根据mayInterruptIfRunning(强制中断) 判断是否中断线程
             * 中断后会抛出InterruptedException异常
             */
            future.cancel(true);

            String s = future.get();
            System.out.println("result: "+ s);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        Callable<String> interruptTask = () -> {
            // 周期性检查当前线程是否中断
            if (Thread.currentThread().isInterrupted()) return "interrupted";
            return "success";
        };
    }

    private static void testInvokeAll() {
        List<Callable<String>> callableList = new ArrayList<>();

        for (int i=0; i< 5; i++ ){
            callableList.add(() -> {
                return "hhhh";
            });
        }

        try {
            /**
             * invokeAll: 等待多个子任务完成结果(promiseAll) 超时会取消未完成的task
             * invokeAny: 任何一个task成功完成(没有异常抛出), 其他任务被取消
             */
            List<Future<String>> futureList = threadPool.invokeAll(callableList);

            threadPool.invokeAny(callableList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
