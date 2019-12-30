package io.ilss.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7};
        int result = search2(arr, 3);
        System.out.println(result);
        result = search(arr, 3);
        System.out.println(result);
        List<Integer> integers = search3(arr, 3);
        System.out.println(integers);

    }

    /**
     * 循环实现
     *
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr, int value) {
        int left = 0, right = arr.length-1;
        int i = 0;
        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
            if (arr[mid] == value) {
                return mid;
            }
            if (value < arr[mid]) {
                right = mid - 1;
                continue;
            }
            if (value > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search2(int[] arr, int value) {
        return search2(arr, 0, arr.length - 1, value);
    }

    /**
     * 递归实现
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    private static int search2(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value < arr[mid]) {
            return search2(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            return search2(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    public static List<Integer> search3(int[] arr, int value) {
        return search3(arr, 0, arr.length - 1, value);
    }

    private static List<Integer> search3(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value < arr[mid]) {
            return search3(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            return search3(arr, mid + 1, right, value);
        } else {
            List<Integer> result = new ArrayList<>();
            result.add(mid);
            int leftIdx = mid - 1;
            int rightIdx = mid + 1;
            while (leftIdx >= 0 && value == arr[leftIdx]) {
                result.add(leftIdx);
                leftIdx--;
            }
            while (rightIdx < arr.length && value == arr[rightIdx]) {
                result.add(rightIdx);
                rightIdx++;
            }
            return result;
        }
    }
}
