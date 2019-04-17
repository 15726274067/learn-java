package com.zhutao.javacore.basic.extend.employee;

/**
 * @Author: zhutao
 * @Date: 2019/4/17 10:18
 * @Version 1.0
 */
public class Person {
    public Person() {
        Employee employee = new Employee("hhh");
        System.out.println(employee.name);
    }
}

