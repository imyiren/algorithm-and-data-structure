package com.imyiren.datastructure.leetcode.array;

import java.util.Arrays;

/**
 * @author yiren
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[idx]) {
                idx++;
                nums[idx] = nums[j];
            }
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("result: " + new Q26().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
