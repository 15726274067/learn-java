package com.zhutao.lambda;

import com.zhutao.lambda.functions.MyFunction;
import org.junit.Test;

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
    @Test
    public void one(){
        repeat(10, i -> System.out.println("counting down: " + (9 - i)));
    }


    /**
     * 实现自己的函数式接口
     */
    @Test
    public void two(){
        testMyFunc((x, y) -> x + "hahaha");
    }

    /**
     * lambda的作用域
     * lambda没有自己的作用域,它使用的是调用者(嵌套代码块)的作用域
     * 因此lam中的this代表的是创建lam表达式方法的this
     */
    @Test
    public void three(){

    }

    public void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++){
            action.accept(i);
        }
    }

    /**
     * 函数式编程
     * 将实现逻辑抽离,由调用方提供
     * @param myFunction
     */
    public void testMyFunc(MyFunction<String, Integer> myFunction){
        String res = myFunction.run("internal: ", 1);
        System.out.println(res);
    }
}
