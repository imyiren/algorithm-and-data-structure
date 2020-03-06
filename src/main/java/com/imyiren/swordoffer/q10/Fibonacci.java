package com.imyiren.swordoffer.q10;

/**
 * @author yiren
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(recursion(1));
        System.out.println(loop(1));
        System.out.println(recursion(5));
        System.out.println(loop(5));
        System.out.println(recursion(7));
        System.out.println(loop(7));

    }

    private static long recursion(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1L;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    private static long loop(int n) {
        int[] result = {0, 1};
        if (n <= 1) {
            return result[n];
        }
        int fib1 = result[0];
        int fib2 = result[1];
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return fib1 + fib2;
    }
}
