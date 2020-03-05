package com.imyiren.swordoffer.q04;

/**
 * @author yiren
 */
public class Search2DimensionArr {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(search(arr, 99));
    }

    private static boolean search(int[][] arr, int target) {
        if (null == arr || arr.length < 1 || arr[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
