package com.zhutao.learn.core.javacore.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhutao
 * @Date: 2019/4/17 20:14
 * @Version 1.0
 */
public class ReflectTest {
    public static void main(String[] args){

    }

    public static void printClassMethods(String className){
        try {
            Class<?> cls = Class.forName(className);
            while (cls!=null){
                for(Method method: cls.getDeclaredMethods()){
                    System.out.println(method.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object createInstance(String className) {
        Class<?> cls = null;
        try {
            cls = Class.forName(className);
            // 调用无参构造函数
            Object o = cls.newInstance();

            // 调用带参构造函数,需要先获取构造函数
            Constructor constructor = cls.getConstructor(int.class);
            Object o1 = constructor.newInstance(1);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
