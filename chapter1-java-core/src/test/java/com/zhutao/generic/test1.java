package com.zhutao.generic;

import com.zhutao.generic.pojo.Employee;
import com.zhutao.generic.pojo.Manager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/13 14:42
 * @Version 1.0
 */
public class test1 {

    private Employee[] employees = new Employee[10];

    private Manager[] managers = new Manager[10];

    private ArrayList<Employee> employeeList = null;

    private ArrayList<Manager> managerList = null;

    @Before
    public void before(){
        Employee employee = null;

        Manager manager = null;
        for (int i=0; i< 5; i++){
            employee = new Employee("employee" + i, 1);
            manager = new Manager("manager" + i, 1, "a");

            employees[i] = employee;
            managers[i] = manager;
        }
        employeeList = new ArrayList<>(Arrays.asList(employees));

        managerList = new ArrayList<>(Arrays.asList(managers));
    }
    /**
     * Java中 数组是协变的
     * 泛型是不变的
     */
    @Test
    public void testCovariance(){


        /**
         * 不会报错,数组具有协变性
         * Manager[] 是 Employee[]的子类
         */
        Employee.process(managers);

        /**
         * 会报错, 因为泛型不具有协变性 List<Manager> 不是 List<Employee>的子类
         */
//        Employee.processList(managerList);
    }

    /**
     *协变的风险
     */
    @Test
    public void testCovariance2(){
        Manager[] managers = new Manager[10];
        Employee[] empls = managers;
        empls[0] = new Employee();
    }

    /**
     * 子类型通配符
     */
    @Test
    public void testChildCharacter(){
        Employee.printName(managerList);
    }
}
