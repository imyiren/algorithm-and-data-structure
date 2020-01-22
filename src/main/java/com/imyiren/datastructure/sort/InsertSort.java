package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author yiren
 */
public class InsertSort {
    public static void sort(int[] arr) {
        // 每一轮要插入的元素
        int insertValue;
        // 需要插入的位置
        int idx;
        for (int i = 1; i < arr.length; i++) {
            // 记录需要插入的元素
            insertValue = arr[i];
            // 记录需要插入的位置
            idx = i;
            // j >= 0 && insertValue < arr[j] 只要位置大于零 且 插入的值小于当前的值就继续移位
            for (int j = i - 1; j >= 0 && insertValue < arr[j]; j--) {
                // 往后移
                arr[j + 1] = arr[j];
                // 记录当前移动的项的位置
                idx = j;
            }
            // 最后把要插入的值放入要插入的位置
            arr[idx] = insertValue;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{11, 3, 4, 1, 2, 3, 5, 33};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
