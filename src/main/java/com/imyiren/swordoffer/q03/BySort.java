package com.imyiren.swordoffer.q03;

import java.util.Arrays;

/**
 * 时间O( n log n ) 空间O(1)
 * @author yiren
 */
public class BySort {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 3, 6, 5, 7};
        System.out.println(repeatNum(arr));
    }

    /**
     * 重复元素
     * @param arr
     * @return
     */
    public static Integer repeatNum(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return null;
    }

    /**
     * 变体：找出重复元素最多的个数
     * @param arr
     * @return
     */
    public static Integer repeatNumCount(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Arrays.sort(arr);
        int j, maxCount = 1, maxValue = arr[0];
        for (int i = 0; i < arr.length - 1; i = i + j) {
            j = 1;
            while (arr[i] == arr[i + j] && j < arr.length) {
                j++;
            }
            maxCount = Math.max(maxCount, j);

            if (maxCount > arr.length / 2) {
                break;
            }
        }
        return maxCount;
    }
}
