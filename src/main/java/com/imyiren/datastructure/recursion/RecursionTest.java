package com.imyiren.datastructure.recursion;

/**
 * @author yiren
 */
public class RecursionTest {
    private static void test(int n) {
        if (n > 1) {
            test(n - 1);
        }
        System.out.print(n + " ");
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        System.out.println("=====> 递归实现数数");
        test(4);
        System.out.println();
        System.out.println("=====> 递归实现阶乘");
        System.out.println(factorial(3));
    }
}
