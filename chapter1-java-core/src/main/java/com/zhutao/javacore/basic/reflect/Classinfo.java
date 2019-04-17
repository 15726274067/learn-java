package com.zhutao.javacore.basic.reflect;

import java.util.ArrayList;

/**
 * 1. 运行时获取类型信息和资源
 * 2. 类加载机制
 * @Author: zhutao
 * @Date: 2019/4/17 18:20
 * @Version 1.0
 */
public class Classinfo {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(Classinfo.class);
        Class<?> cls = arrayList.getClass();
        System.out.println(cls.getTypeName());

        /**
         * 加载类
         */
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
