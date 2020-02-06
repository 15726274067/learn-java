package com.zhutao.learn.core.javacore.concurrence.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 竞争条件
 * 多线程竞争更新共享变量,cpu时间片结束前未能成功更新,操作丢失
 *
 * 安全并发的策略
 * 1. 限制: 限制对共享变量的访问
 * 2. 不变性: 共享不可修改的变量是安全的
 * 3. 使用锁, 使用线程安全的数据结构(最后的手段)
 * @Author: zhutao
 * @Date: 2019-07-11 09:48
 * @Version 1.0
 */
public class RaceConditionMain {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static volatile int count = 0;
    public static void main(String[] args) {
        testRaceCondition();
    }

    public static void testRaceCondition() {
        for (int i = 0; i< 100; i++) {
            int taskId = i;
            Runnable task = () -> {
                for (int j=0; j< 1000;j ++){
                    /**
                     * 多线程下
                     * 这里对count的更新不会全部成功
                     * 需要使用锁使得操作的临界序列成为不可分的原子更新操作
                     */
                    count++;
                }
                System.out.println(taskId + ": " + count);
            };

            executorService.execute(task);
        }

    }
}
