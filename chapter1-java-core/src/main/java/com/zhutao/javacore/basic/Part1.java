package com.zhutao.javacore.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: zhutao
 * @Date: 2019/1/26 20:03
 * @Version 1.0
 */
public class Part1 {
    /**
     * array list互转
     */
    public static void test1(){
        String[] strings = { "" };

        ArrayList<String> arrayList = new ArrayList(Arrays.asList(strings));

        ArrayList<String> list = new ArrayList<>(Arrays.asList("111", "222"));

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1,2,3,4));

        Collections.shuffle(list);

        String[] arr = list.toArray(new String[0]);

        Object[] arra = list.toArray();
    }

    public static void test2(){
        int[] ints = { 1, 2, 3, 4 };

//        IntStream intStream = IntStream.of(ints);
//        intStream.collect(Collectors.toCollection();

        Stream stream = Stream.of(ints);

        Integer[] a = (Integer[]) stream.toArray(Integer::new);

        List<Integer> integerList = new ArrayList<>();
    }
}
