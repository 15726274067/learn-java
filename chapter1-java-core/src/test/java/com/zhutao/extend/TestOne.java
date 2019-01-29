package com.zhutao.extend;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Author: zhutao
 * @Date: 2019/1/29 14:14
 * @Version 1.0
 */
public class TestOne {
    @Test
    public void one(){
        Manager[] managers = new Manager[10];

        Employee[] employees = managers;

        /**
         * 可以将子类型数组赋值给父类,但是向数组中增加父类对象时,会抛出异常
         * java.lang.ArrayStoreException
         * employees[0] = new Employee("z");
         *
         * 添加子类对象,是可以的
         */
        employees[0] = new Manager("z", 12);

        // [Lcom.zhutao.extend.Manager;@22d8cfe0
        System.out.println(employees.toString());

        // com.zhutao.extend.Manager[]
        System.out.println(employees.getClass().getTypeName());
        // com.zhutao.extend.Manager[]
        System.out.println(employees.getClass().getCanonicalName());

    }
}
