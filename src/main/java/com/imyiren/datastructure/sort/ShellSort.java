package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author yiren
 */
public class ShellSort {
    /**
     * 交换法
     * 速度不是很快
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        int temp;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 从左到右依次做交换 把每个位置换到合适的位置 但是每一笔都要交换 运算比较多
            for (int i = step; i < arr.length; i++) {
                // 分组做交换
                for (int idx = i - step; idx >= 0 && arr[idx] > arr[idx + step]; idx = idx - step) {
                    temp = arr[idx];
                    arr[idx] = arr[idx + step];
                    arr[idx + step] = temp;
                }
            }
        }
    }

    /**
     * 移动法
     * 记这个
     *
     * @param arr 数组
     */
    public static void sort2(int[] arr) {
        // logN
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 使用分组插入排序  移动来做插入排序
            for (int i = step; i < arr.length; i++) {
                int idx = i;
                int insertValue = arr[i];
                for (int j = i - step; j >= 0 && arr[j] > insertValue; j -= step) {
                    arr[j + step] = arr[j];
                    idx = j;
                }
                arr[idx] = insertValue;
            }
        }

    }

    /**
     * @param arr
     */
    public static void sort3(int[] arr) {
        // logN
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 使用分组插入排序
            for (int i = step; i < arr.length; i++) {
                int idx = i;
                int insertValue = arr[i];
                if (arr[idx] < arr[idx - step]) {
                    while (idx - step >= 0 && insertValue < arr[idx - step]) {
                        // 把前一个往后移一位
                        arr[idx] = arr[idx - step];
                        // 记录前一个位置
                        idx = idx - step;
                    }
                    arr[idx] = insertValue;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 3, 4, 1, 2, 3, 5, 33};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
