package io.ilss.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：o(n^2)
 * @author feng
 */
public class SelectSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            // 避免每次寻址？
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    idx = j;
                    min = arr[j];
                }
            }
            if (idx != i) {
                arr[idx] = arr[i];
                arr[i] = min;
            }
        }
    }

    /**
     * 优化 增加交换标志量 减少不必要的循环
     *
     * @param arr
     */
    public static void sort2(int[] arr) {

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

