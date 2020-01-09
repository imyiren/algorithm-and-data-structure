package io.ilss.datastructure.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * @author feng
 */
public class Q16 {


    // O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        // shell排序
        for (int step = nums.length / 2; step > 0; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int idx = i;
                int insertValue = nums[i];
                for (int j = i - step; j >= 0 && nums[j] > insertValue; j -= step) {
                    idx = j;
                    nums[j + step] = nums[j];
                }
                nums[idx] = insertValue;
            }
        }
        // Arrays.sort(nums);
        // 双指针法
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1, right = nums.length - 1;
            while ( left < right) {
                int tmpSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(tmpSum - target) < Math.abs(sum - target)) {
                    sum = tmpSum;
                }
                if (tmpSum > target) {
                    right--;
                } else if (tmpSum < target) {
                    left++;
                } else {
                    return tmpSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int i = new Q16().threeSumClosest(nums, 1);
        System.out.println("result: "+i);
    }
}
