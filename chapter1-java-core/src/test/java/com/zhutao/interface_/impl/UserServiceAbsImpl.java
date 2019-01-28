package com.zhutao.interface_.impl;

import com.zhutao.interface_.abst.UserServiceAbst;

import java.io.Serializable;

/**
 * 1. 继承部分实现接口的抽象类,会被要求实现抽象类中未实现的接口
 * 2. 在此基础上,实现接口无意义..
 *
 * 类总是比接口优先,类中方法比接口的默认实现优先
 * @Author: zhutao
 * @Date: 2019/1/28 11:26
 * @Version 1.0
 */
public class UserServiceAbsImpl extends UserServiceAbst
        implements  Serializable {
    @Override
    public void remove(String name) {

    }

    @Override
    public void get2(String name) {

    }


    @Override
    public void add(String name){

    }
}
