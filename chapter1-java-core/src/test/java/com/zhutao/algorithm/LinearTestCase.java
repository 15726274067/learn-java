package com.zhutao.algorithm;

import com.zhutao.algorithm.linear.DoubleLink;
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
}
