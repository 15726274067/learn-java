package com.zhutao.generic.pojo;

/**
 * @Author: zhutao
 * @Date: 2019/2/13 14:40
 * @Version 1.0
 */
public class Manager extends Employee {
    private String desc;

    public Manager() {
    }

    public Manager(String name, int age, String desc) {
        super(name, age);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                "desc='" + desc + '\'' +
                '}';
    }
}
