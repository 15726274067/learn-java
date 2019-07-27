package com.zhutao.javacore.concurrence.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: zhutao
 * @Date: 2019-07-21 16:58
 * @Version 1.0
 */
public class ThreadState {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 获得所有线程id
        long[] threadIds = threadMXBean.getAllThreadIds();
        for (long threadId: threadIds) {

            // 根据线程id获取详细信息
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            System.out.println(threadInfo);
        }
    }
}
