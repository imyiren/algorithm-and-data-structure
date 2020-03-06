package com.imyiren.swordoffer.q11;

/**
 * @author yiren
 */
public class CycleArr {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1};
        System.out.println(cycleArrMinNum(arr));
    }

    private static Integer cycleArrMinNum(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        int left = 0;
        int right = arr.length - 1;
        int middle = left;
        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = (left + right) / 2;
            if (arr[middle] >= arr[left]) {
                left = middle;
            } else if (arr[middle] <= arr[right]) {
                right = middle;
            }
        }
        return arr[middle];
    }
}
