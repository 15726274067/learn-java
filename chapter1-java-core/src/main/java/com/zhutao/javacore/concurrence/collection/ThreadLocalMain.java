package com.zhutao.javacore.concurrence.collection;

/**
 * @Author: zhutao
 * @Date: 2019/4/27 14:11
 * @Version 1.0
 */
public class ThreadLocalMain {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void start(){
        for (int i = 0; i<10; i++) {
            new Thread(() -> {
                threadLocal.set(1);
                threadLocal.get();
                threadLocal.remove();
            }).start();
        }

    }

    private static class Test {
        public static void main(String[] args){
            
        }
    }
}
