package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author feng
 */
public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        int leftPtr = left, rightPtr = right;
        // 中轴
        int pivot = arr[(left + right) / 2];
        int temp;
        // 只要左右两边没有循环
        while (leftPtr < rightPtr) {
            while (arr[leftPtr] < pivot) {
                leftPtr++;
            }
            while (arr[rightPtr] > pivot) {
                rightPtr--;
            }
            if (leftPtr >= rightPtr) {
                break;
            }

            temp = arr[leftPtr];
            arr[leftPtr] = arr[rightPtr];
            arr[rightPtr] = temp;

            if (arr[leftPtr] == pivot) {
                rightPtr--;
            }
            if (arr[rightPtr] == pivot) {
                leftPtr++;
            }
        }

        if (leftPtr == rightPtr) {
            leftPtr++;
            rightPtr--;
        }

        if (left < rightPtr) {
            sort(arr, left, rightPtr);
        }
        if (right > leftPtr) {
            sort(arr, leftPtr, right);
        }

    }

    public static void sort2(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static void sort2(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > left) {
            sort2(arr, left, i - 1);
        }
        if (j + 1 < right) {
            sort2(arr, j + 1, right);
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{11, 3, 4, 1, 2, 3, 5, 33, 22};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
