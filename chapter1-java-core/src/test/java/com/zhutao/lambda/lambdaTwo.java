package com.zhutao.lambda;

import java.util.function.IntConsumer;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 16:10
 * @Version 1.0
 */
public class lambdaTwo {

    /**
     * 实现延迟执行
     */
    public void One(){

    }

    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++){
            action.accept(i);
        }
    }
}
