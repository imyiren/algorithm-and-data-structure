package com.imyiren.datastructure.search;

import com.imyiren.datastructure.sort.QuickSort;

import java.util.Arrays;
import java.util.List;

/**
 * @author yiren
 */
public class Main {
    public static void main(String[] args) {
        final int len = 2000;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * len / 100);
        }
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[1111]);
        System.out.println(System.currentTimeMillis());
        // int index = BinarySearch.search2(arr, arr[333]);
        List<Integer> result = BinarySearch.search3(arr, arr[1111]);
        System.out.println(System.currentTimeMillis());
        System.out.println(result);
    }
}
