package com.zhutao.javacore.interface_;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 14:05
 * @Version 1.0
 */
public interface BookService {
    void add(String name);

    void remove(String name);

    /**
     * 默认实现
     * @param name
     */
    default void get(String name){
        System.out.println("BookService get");
        return;
    }


    /**
     * 静态方法
     */
    static void show(){
        System.out.println("BookService static show");
    }

    /**
     * 默认实现
     * @param name
     */
    default void get2(String name){
        System.out.println("BookService get2");
        return;
    }

}
