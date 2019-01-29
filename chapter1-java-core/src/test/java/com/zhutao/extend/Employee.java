package com.zhutao.extend;

import java.util.Objects;

/**
 * 实现一个类
 * 1. 是否提供clone()?
 * 2. 是否接受Object的clone()
 * 3. 如何实现深拷贝的clone()
 * 实现Cloneable接口的类,才可以调用clone方法
 * @Author: zhutao
 * @Date: 2019/1/29 14:10
 * @Version 1.0
 */
public class Employee implements Cloneable {
    String name;

    public Employee(String name) {
        this.name = name;
        String a = "a" + "b" + "c";
        System.out.println(a + "aaa");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写equals方法
     * 0. 有父类且父类重写了equals,先调用父类的equals
     * 1. 检查引用是否相同
     * 2. 判断不为null
     * 3. 类型检查, 类型转换
     *      - 通过instanceof
     *      - getClass
     * 4. 比较实例变量
     *      - 基本类型, ==操作符
     *      - 对象 Object.equals
     *      - 数组: Arrays.equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    /**
     * 重写hashCode
     * @return
     */
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
