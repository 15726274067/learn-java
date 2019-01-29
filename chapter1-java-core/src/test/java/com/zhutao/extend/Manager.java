package com.zhutao.extend;

/**
 * @Author: zhutao
 * @Date: 2019/1/29 14:11
 * @Version 1.0
 */
public class Manager extends Employee {
    int age;

    public Manager(String name, int age) {
        super(name);
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void test(){
        throw new RuntimeException("hahaha");
    }

    public void test1(){
        this.test();
    }
}
