package com.zhutao.javacore.concurrence.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * JUC下的集合迭代器的缺陷
 * 集合产生弱一致性的迭代器, 迭代器中的元素可能没有反映在构建后集合所做的部分或全部修改
 * 这样的迭代器不会抛出ConcurrentModificationException
 *
 * ConcurrentHashMap
 * 线程安全的哈希表,高效支持大量的并发读操作及一定量的并发写操作
 * 这里会带你解析ConcurrentHashMap源码
 * @Author: zhutao
 * @Date: 2019-07-11 10:05
 * @Version 1.0
 */
public class ConcurrentHashMapMain {
    public static void main(String[] args) {
        /**
         *
         */
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    }

    public static void testMapCompute() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // put()不是线程安全的,因为其他线程可能同时对他进行更新
        map.put("11", "11");

        /**
         * 线程安全更新,使用compute方法(原子操作)
         * computeIfAbsent() / computeIfPresent()
         */
        map.compute("11", (k, v) -> v == null? "" : v);
    }
}
