package com.zhutao.learn.core.javacore.basic.enumeration;

import java.util.Arrays;

/**
 * @Author: zhutao
 * @Date: 2019/4/17 18:06
 * @Version 1.0
 */
public class TestEnum {

    public static void main(String[] args){

        Size[] sizes = Size.values();
        System.out.println(Size.LARGE);
        System.out.println(Arrays.toString(sizes));
    }
}
