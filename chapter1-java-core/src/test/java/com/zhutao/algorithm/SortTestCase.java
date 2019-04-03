package com.zhutao.algorithm;

import org.junit.Test;

import static com.zhutao.algorithm.sort.BubbleSort.bubbleSort;

/**
 * @Author: zhutao
 * @Date: 2019/4/3 11:10
 * @Version 1.0
 */
public class SortTestCase {

    @Test
    public void testBubbleSort(){
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bubbleSort(a, a.length);
        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
