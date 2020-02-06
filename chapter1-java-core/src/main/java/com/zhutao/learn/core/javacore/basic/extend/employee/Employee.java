package com.zhutao.learn.core.javacore.basic.extend.employee;

import java.util.Objects;

/**
 * @Author: zhutao
 * @Date: 2019/4/17 10:17
 * @Version 1.0
 */
public class Employee implements Cloneable {
    protected String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 判断对象引用是否相等
        if (this == obj) return true;

        // 2. 与null比较时,返回false
        if (obj == null) return false;

        // 3. 比较类型
        if (this.getClass() != obj.getClass()) return false;

        // 4. 检查实例变量值是否相同
        // 需要进行类型转换
        // 使用Objects#equals (null安全) 进行对象比较
        // 使用==进行基本类型比较(double类型可以使用Double#equals避免NaN)
        // 使用Arrays#equals进行数组的比较
        Employee employee = (Employee) obj;

        return Objects.equals(this.name, employee.name);
    }

    /**
     *重定义equals后,必须重写hashCode方法,否则类在插入hashMap时可能会丢失(hashcode相同)
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * 浅拷贝
     *
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
