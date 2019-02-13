package com.zhutao.generic.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: zhutao
 * @Date: 2019/2/13 14:40
 * @Version 1.0
 */
public class Employee {
    private String name;

    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void process(Employee[] employees){

        System.out.println(Arrays.toString(employees));
    }

    public static void processList(List<Employee> employees){
        System.out.println(employees);
    }

    /**
     * 1.子类型通配符
     * @param employees
     */
    public static void printName(ArrayList<? extends Employee> employees){
        System.out.println(employees);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void printAll0(Employee[] staff, Predicate<Employee> filter){
        for (Employee employee: staff){
            if (filter.test(employee)) {
                System.out.println(employee);
            }
        }
    }

    public static void printAll(Employee[] staff, Predicate<? super Employee> filter){
        for (Employee employee: staff){
            if (filter.test(employee)) {
                System.out.println(employee);
            }
        }
    }

    public static boolean hasNulls(ArrayList<?> elements){
        for (Object e: elements){
            System.out.println(e);
        }
        return false;
    }

    public static void swap(ArrayList<? extends Employee> employees, int i, int j){
       // ? temp = employees.get(i); 行不通

        swapHelper(employees, i, j);
    }

    public static <T extends Employee> void swapHelper(ArrayList<T> elements, int i, int j){
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
