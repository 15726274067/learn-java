package com.zhutao.lambda;

import com.zhutao.lambda.functions.MyFunction;
import org.junit.Test;

import java.util.Comparator;
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
     * <p>lambda的作用域</p>
     * lambda没有自己的作用域,它使用的是调用者(嵌套代码块)的作用域
     * 因此lam中的this代表的是创建lam表达式方法的this
     */
    @Test
    public void three(){

        /**
         * 1. 方法体与嵌套代码块有相同的作用域
         * 以下代码会有命名冲突
         * <code>
         *     int first = 0;
         *     Comparator<String> comparator = (first, second) -> first.length() - second.length();
         * </code>
         */



        repeatMes("haha", 10);

    }

    /**
     * 访问来自闭合作用域的变量(闭包)
     *
     */
    public void repeatMes(String text, int count){
        /**
         * lam的三部分
         * 1. 代码块
         * 2. 参数
         * 3. 自由变量的值(由lam进行捕获,仅仅是值)
         *
         */
        Runnable r = () -> {
            for (int i = 0; i < count; i++){
                // lam不能改变任何捕获的变量(的引用)
                // count --;
                System.out.println(text);
            }
        };
        new Thread(r).run();

        /**
         * lam中,自由变量不能被改变
         * 即lam中的变量应该为final或有效final的
         * 以下代码会编译报错
         * <code>
         *     for (int i=0; i< count; i++){
         *       new Thread(() -> System.out.println(i)).run();
         *     }
         * </code>
         */

        /**
         * 增强for循环中,这样写是允许的
         * 原因:
         * 里面的变量是有效final的
         * arg的作用域是单个迭代,每个迭代都会新建arg变量
         */
        String[] args = { "a", "b" };
        for (String arg: args){
            new Thread(() -> System.out.println(arg)).run();
        }
    }

    /**
     * 可以通过使用长度为1的数组,绕过此不能更改捕获变量的限制
     * 在此func中,counts变量是有效final的
     * 注意线程安全
     */
    @Test
    public void four(){
        repeatCanChange("ha", 10);
    }

    public synchronized void repeatCanChange(String text, int count){
        int[] counts = { count };
        Runnable r = () ->{
            for (int i = 0; i <= counts[0]; i +=2){
                counts[0] ++;
                System.out.println(text);
            }
        };

        new Thread(r).run();
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
