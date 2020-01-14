package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author feng
 */
public class MergeSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private static void sort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        // 中间的位置
        int mid = (left + right) / 2;
        // 递归分解
        sort(arr, left, mid, tempArr);
        sort(arr, mid + 1, right, tempArr);

        // 合并
        // merge(arr, left, mid, right, tempArr);
        int i = left, j = mid + 1;
        // 临时数组的索引
        int idx = 0;
        // 两边的数据按规则复制到tempArr中， 直到有一边处理完毕
        while (i <= mid && j <= right) {
            // 如果左边的当前值小于等于右边的元素，就拷贝左边的到tempArr，否则拷贝右边  ，然后后移索引
            if (arr[i] <= arr[j]) {
                tempArr[idx] = arr[i];
                idx++;
                i++;
            } else {
                tempArr[idx] = arr[j];
                idx++;
                j++;
            }
        }
        // 把有剩余的一边复制到tempArr中去
        while (i <= mid) {
            tempArr[idx] = arr[i];
            idx++;
            i++;
        }
        while (j <= right) {
            tempArr[idx] = arr[j];
            idx++;
            j++;
        }

        // 将temp数组中的元素拷贝到arr
        idx = 0;
        while (left <= right) {
            arr[left] = tempArr[idx];
            idx++;
            left++;
        }

    }

    /**
     * @param arr     排序的原始数组
     * @param left    左边索引
     * @param mid     中间索引
     * @param right   右边索引
     * @param tempArr 临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {

    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 4, 7, 1, 3, 6, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
