package com.imyiren.swordoffer.q03;

/**
 * @author yiren
 */
public class ByBestMethod {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 3, 6, 5, 7};
        System.out.println(repeatNum(arr));
    }

    private static Integer repeatNum(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return null;
    }
}


