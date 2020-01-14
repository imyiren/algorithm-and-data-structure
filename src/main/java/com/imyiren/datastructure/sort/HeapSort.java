package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author feng
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int temp;
        // 调整成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp;
        temp = arr[i];
        // i*2 + 1 是i的左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 说明左子节点值 小于右子节点的值
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                // j指向右子节点
                j++;
            }
            // 如果子节点大于父节点
            if (arr[j] > temp) {
                // 把大值给当前节点
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
            // for循环结束 以i为父节点的树的最大是放在了i的位置
        }
        // 将原来i的值赋到 被交换的地方。
        arr[i] = temp;
    }


    public static void main(String[] args) {
        // 升序  使用大顶堆
        int[] arr = {4, 1, 3, 54, 6, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
