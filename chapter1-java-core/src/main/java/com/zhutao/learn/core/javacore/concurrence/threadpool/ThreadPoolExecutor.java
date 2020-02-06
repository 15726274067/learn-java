package com.zhutao.learn.core.javacore.concurrence.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhutao
 * @Date: 2019-07-18 20:54
 * @Version 1.0
 */
public class ThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
    }
}
