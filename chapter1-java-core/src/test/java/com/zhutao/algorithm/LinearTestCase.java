package com.zhutao.algorithm;

import com.zhutao.algorithm.linear.ArrayQueue;
import com.zhutao.algorithm.linear.DoubleLink;
import com.zhutao.algorithm.linear.ArrayStack;
import org.junit.Test;

/**
 * @Author: zhutao
 * @Date: 2019/4/3 10:15
 * @Version 1.0
 */
public class LinearTestCase {

    @Test
    public void testDoubleLink(){
        // 创建双向链表
        DoubleLink<Integer> dlink = new DoubleLink<>();

        dlink.insert(0, 20);    // 将 20 插入到第一个位置
        dlink.appendLast(10);    // 将 10 追加到链表末尾
        dlink.insertFirst(30);    // 将 30 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());

        // 打印出全部的节点
        for (int i=0; i<dlink.size(); i++)
            System.out.println("dlink("+i+")="+ dlink.get(i));
    }

    @Test
    public void testStack(){
        String tmp;
        ArrayStack<String> stack = new ArrayStack<>(String.class);

        // 将10, 20, 30 依次推入栈中
        stack.push("10");
        stack.push("20");
        stack.push("30");

        // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        tmp = stack.pop();
        System.out.println("tmp="+tmp);

        // 只将“栈顶”赋值给tmp，不删除该元素.
        tmp = stack.peek();
        System.out.println("tmp="+tmp);

        stack.push("40");
        stack.PrintArrayStack();    // 打印栈
    }

    @Test
    public void testQueue(){
        int tmp = 0;
        ArrayQueue queue = new ArrayQueue(12);

        // 将10, 20, 30 依次推入栈中
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        tmp = queue.pop();
        System.out.printf("tmp=%d\n", tmp);

        // 只将“栈顶”赋值给tmp，不删除该元素.
        tmp = queue.front();
        System.out.printf("tmp=%d\n", tmp);

        queue.add(40);

        System.out.printf("isEmpty()=%b\n", queue.isEmpty());
        System.out.printf("size()=%d\n", queue.size());
        while (!queue.isEmpty()) {
            System.out.printf("size()=%d\n", queue.pop());
        }
    }
}
