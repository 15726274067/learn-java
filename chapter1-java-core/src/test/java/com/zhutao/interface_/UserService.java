package com.zhutao.interface_;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 11:22
 * @Version 1.0
 */
public interface UserService {
    void add(String name);

    void remove(String name);

    /**
     * 默认实现
     * @param name
     */
    default void get(String name){
        System.out.println("UserService get");
        return;
    }

    void get2(String name);
}
