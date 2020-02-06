package com.zhutao.learn.core.algorithm.search;

/**
 * @Author: zhutao
 * @Date: 2019/9/8 20:11
 * @Version 1.0
 */
public class BinarySearch {
    /**
     * [1,2,5,6]
     * @param arr
     * @param num
     * @return
     */
    public static int binarySearch(int[] arr, int num) {
        int idxl = 0, idxr = arr.length;

        while (idxl <= idxr) {
            int mid = (idxl + idxr)/ 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                idxr = mid - 1;
            } else {
                idxl = mid + 1;
            }
        }
        return -1;
    }

}
