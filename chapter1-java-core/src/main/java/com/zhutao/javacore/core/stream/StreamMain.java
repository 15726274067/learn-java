package com.zhutao.javacore.core.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流(stream)提供了数据视图, 使操作者可以在集合更高的概念层上操作
 * 核心思想: 操作者只需要指定做什么,而不是怎么做,流类库会自动优化计算选择最优解
 *
 * 步骤
 * 1. 创建流
 * 2. 中间操作(初始流->其他流)
 * 3. 终止操作产生结果
 * @Author: zhutao
 * @Date: 2019/2/16 15:03
 * @Version 1.0
 */
public class StreamMain {
    public static void main(String[] args){
        List<String> list = Arrays.asList("aaa", "vvv", "fffff");

        // 简单的stream操作
        final long count = list.stream().filter( x-> x.length() > 3 ).count();
        System.out.println(count);

        // 并行stream(parallelStream)
        boolean match = list.parallelStream().limit(2).allMatch(x -> x.length() == 3);
        System.out.println(match);
    }
}
