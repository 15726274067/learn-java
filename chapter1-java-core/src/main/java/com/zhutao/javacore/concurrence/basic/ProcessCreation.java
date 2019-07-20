package com.zhutao.javacore.concurrence.basic;


import java.io.IOException;

/**
 * 进程创建
 * @Author: zhutao
 * @Date: 2019/7/20 12:58
 * @Version 1.0
 */
public class ProcessCreation {
    public static void main(String[] args) {
        // 获取Java运行时
        Runtime runtime = Runtime.getRuntime();
        try {
            // 创建进程
            Process process = runtime.exec("calc");

            Thread.sleep(3000);

            // 停止进程
            process.exitValue();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
