package com.zhutao.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 15:08
 * @Version 1.0
 */
public class lambdaOne {
    @Test
    public void one(){
        /**
         * 方法引用
         * 1. 类::实例方法
         * String::length => x -> x.length()
         * Integer::compareTo  (x, y) -> x.compareTo(y)
         * 参数列表第一个参数作为方法的调用者
         * 其他参数作为方法的参数
         *
         * 2. 类::静态方法
         * 所有参数传给静态方法
         *
         * 3. 对象::实例方法
         * 给定对象上调用方法,参数传递给实例方法
         * System.out::println => System.out.println()
         */

        Comparator<String> comparator = Comparator.comparingInt(String::length);
        String[] strings = { "aaa", "bbb", "cccc", "dddd" };
        Arrays.sort(strings, comparator);
    }

    /**
     * 构造函数引用
     * 解决无法构造泛型数组
     */
    @Test
    public void two(){
        int[] arr = { 1, 2, 3, 4 };

        /**
         * array -> arrayList
         */
        List list = Arrays.asList(arr);
        ArrayList<Integer> arrayList = new ArrayList<>(list);

        /**
         * arrayList -> array
         * 因为无法构造泛型数组, 这里返回Object数组
         */
        Object[] objects = arrayList.toArray();

        /**
         * 如何解决?
         * 1. 基本类型 array -> int(long/float等) stream -> array
         *
         * 2. 非基本类型 array -> stream -> array
         */

        IntStream intStream = Arrays.stream(arr);
        int[] arr2 = intStream.toArray();
        System.out.println(Arrays.toString(arr2));
        // 可以获得数组的类型
        System.out.println(arr2.getClass().getTypeName());

        String[] strings = { "aaa", "vvvv", "asd" };

        Stream<String> stringStream = Arrays.stream(strings);

        /**
         * 这样会抛出exception
         * java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
         */
//        String[] strings1 = (String[]) stringStream.toArray();


        /**
         * 调用构造函数返回正确的数组
         */
        String[] strings1 = stringStream.toArray(String[]::new);

        System.out.println(Arrays.toString(strings1));
        System.out.println(strings1.getClass().getTypeName());

    }

}
