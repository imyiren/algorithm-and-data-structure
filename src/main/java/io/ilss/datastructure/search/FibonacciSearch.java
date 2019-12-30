package io.ilss.datastructure.search;

import java.util.Arrays;

/**
 * @author feng
 */
public class FibonacciSearch {
    public static int MAX_SIZE = 20;

    public static int search(int[] arr, int value) {
        int[] fibonacci = fibonacci();
        int low = 0;
        int high = arr.length - 1;
        // 斐波那契 分割数值的下标
        int key = 0;
        int mid = 0;
        while (high > fibonacci[key] - 1) {
            key++;
        }
        // 因为fibonacci[key] 可能大于数组的长度 所以我们需要使用Array类 构建一个新的数组，指向arr
        // 不足的部分会以0填充
        int[] tempArr = Arrays.copyOf(arr, fibonacci[key]);
        // 因为后面的数字可能需要拿来做比较，所以把多余的空间用arr[arr.length-1] 填充
        for (int i = arr.length; i < tempArr.length - 1; i++) {
            tempArr[i] = arr[arr.length - 1];
        }

        while (low <= high) {
            mid = low + fibonacci[key - 1] - 1;

            if (value < tempArr[mid]) {
                high = mid - 1;
                key--;
            } else if (value > tempArr[mid]) {
                low = mid + 1;
                key-=2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    public static int[] fibonacci() {
        int[] arr = new int[MAX_SIZE];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int search = search(arr, 3);
        System.out.println(search);
        search = search(arr, 100);
        System.out.println(search);
    }

}
