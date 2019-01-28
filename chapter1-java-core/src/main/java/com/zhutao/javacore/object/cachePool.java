package com.zhutao.javacore.object;

/**
 * 缓存池
 * @Author: zhutao
 * @Date: 2019/1/25 15:50
 * @Version 1.0
 */
public class cachePool {
    public void test(){

        Integer x = new Integer(5);

        Integer y = new Integer(5);
//        System.out.println(x == y);
//        System.out.println(x.equals(y));

        int z = 5;
        System.out.println(x == z);
        System.out.println(x.equals(z));
    }
}
