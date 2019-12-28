package io.ilss.datastructure.sort;

import java.util.Arrays;

/**
 * @author feng
 */
public class InsertSort {
    public static void sort(int[] arr) {
        int insertValue;
        int idx;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            idx = i;
            for (int j = i - 1; j >= 0 && insertValue < arr[j]; j--) {
                arr[j + 1] = arr[j];
                idx = j;
            }
            arr[idx] = insertValue;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{11, 3, 4, 1, 2, 3, 5, 33};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
