package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：o(n^2) 空间复杂度o(1)
 *
 * @author yiren
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        // 避免多次分配内存空间？
        int temp;
        // 注意这个地方length要-1 只需要length-1次就可以了
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化 增加交换标志量 减少不必要的循环
     *
     * @param arr
     */
    public static void sort2(int[] arr) {
        // 避免多次分配内存空间？
        int temp;
        // 注意这个地方length要-1 只需要length-1次就可以了
        for (int i = 0; i < arr.length - 1; i++) {
            // 标志没有一次进入交换
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            // 一次都没有发生 那就直接退出循环
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 3, 4, 1, 2, 3, 5, 33};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{11, 3, 4, 1, 2, 3, 5, 33};
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
