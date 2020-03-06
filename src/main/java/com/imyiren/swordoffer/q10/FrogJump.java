package com.imyiren.swordoffer.q10;

/**
 * @author yiren
 */
public class FrogJump {

    public static void main(String[] args) {
        System.out.println(jumpWayCount(4));
        System.out.println(jumpWayCount2(4));

        System.out.println(jumpWayCount(5));
        System.out.println(jumpWayCount2(5));

        System.out.println(jumpWayCount(9));
        System.out.println(jumpWayCount2(9));
    }

    private static long jumpWayCount(int n) {
        if (n < 0) {
            return -1;
        }
        int[] arr = {0, 1, 2};
        if (n <= 2) {
            return arr[n];
        }

        return jumpWayCount(n - 1) + jumpWayCount(n - 2);
    }
    private static long jumpWayCount2(int n) {
        if (n < 0) {
            return -1;
        }
        int[] arr = {0, 1, 2};
        if (n <= 2) {
            return arr[n];
        }
        int n1 = arr[1];
        int n2 = arr[2];
        int temp = 0;
        for (int i = 3; i < n; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n1 + n2;
    }
}
