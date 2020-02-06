package com.zhutao.learn.core.algorithm.sort;

/**
 * @Author: zhutao
 * @Date: 2019/9/8 20:30
 * @Version 1.0
 */
public class BubbleSort {
    /**
     * 时间复杂度 n2 最优时间复杂度 n 最差时间复杂度 n2
     * 原地排序
     * 稳定的排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        for (int i=0; i < len; i++) {
            boolean swap = false;
            for (int j = 0; j< len-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }
}
