package com.zhutao.interface_.impl;

import com.zhutao.interface_.BookService;
import com.zhutao.interface_.UserService;

/**
 * 实现两个接口, 接口中方法有重名的情况
 * 如果两个接口方法都不包含实现,则无冲突,实现方法是对两个接口中方法的实现
 *
 * 如果两个接口存在默认方法
 * 需手动指定某个父类方法/重写接口方法实现
 * @Author: zhutao
 * @Date: 2019/1/28 14:06
 * @Version 1.0
 */
public class ServiceImpl implements BookService, UserService {
    @Override
    public void add(String name) {
        System.out.println("ServiceImpl add");
    }

    @Override
    public void remove(String name) {
        System.out.println("ServiceImpl remove");
    }

    @Override
    public void get(String name) {
        BookService.super.get("haa");
    }

    @Override
    public void get2(String name) {
        BookService.super.get2("d");
    }

}
