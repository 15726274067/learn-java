package com.zhutao.algorithm.array;

/**
 * Remove Duplicates from Sorted Array
 * 描述
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example, Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 *
 * @Author: zhutao
 * @Date: 2019/4/10 17:57
 * @Version 1.0
 */
public class RemoveDuplicates {
    public static int solution(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index-1])
                nums[index++] = nums[i];
        }
        return index;
    }
}
