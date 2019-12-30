package io.ilss.datastructure.search;

/**
 * @author feng
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 4, 7, 3, 4};
        int idx = search(arr, 5);
        System.out.println(idx);

    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
