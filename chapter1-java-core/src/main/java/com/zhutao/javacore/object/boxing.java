package com.zhutao.javacore.object;

/**
 * 装箱过程是通过调用包装器的valueOf方法实现的
 * 而拆箱过程是通过调用包装器的 xxxValue方法实现的。（xxx代表对应的基本数据类型）
 * @Author: zhutao
 * @Date: 2019/1/25 15:40
 * @Version 1.0
 */

public class boxing {
    public void test1(){
        int y = 2555;

        // 装箱
        Integer x = 2555;
        Integer z = 2555;
        Integer q = y;

        // true
        System.out.println(x == y);

        // true
        System.out.println(x.equals(y));

        // false
        System.out.println(x == z);
        // true
        System.out.println(x.equals(z));

        // false
        System.out.println(x == q);
        // true
        System.out.println(x.equals(q));

        // true
        System.out.println(y == q);
        // true
        System.out.println(q.equals(y));

    }
}
