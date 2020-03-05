package com.imyiren.swordoffer.q03;

/**
 * @author yiren
 */
public class ByNoMoveArr {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 3, 6, 5, 7};
        System.out.println(repeatNum(arr));
    }

    private static Integer repeatNum(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        int start = 1;
        int end = arr.length - 1;
        while (end >= start) {
            int middle = ((end - start) / 2) + start;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= start && arr[i] <= middle) {
                    count++;
                }
            }
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
