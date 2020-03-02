package com.imyiren.algorithm.dynamic;

import java.util.Arrays;

/**
 * @author yiren
 */
public class Package {
    public static void main(String[] args) {
        // 物品重量
        int[] w = {1, 4, 3,2};
        // 物品的价值
        int[] val = {1500, 3000, 2000,2500};
        // 背包容量
        int m = 6;

        int n = val.length;

        // 创建二维数组
        // v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 存放情况记录
        int[][] path = new int[n + 1][m + 1];

        // 初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认就是零
        for (int i = 0; i < v.length; i++) {
            // 第一列
            v[i][0] = 0;
        }
        // 第一行
        Arrays.fill(v[0], 0);

        showArr(v);

        // 从第二列第二行开始，不处理第一行和第一列
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i-1][j]是上一个物品放入后的总价值， val[i-1] 当前的物品的价值，
                    // w[i - 1]是当前的物品的重量，
                    // v[i - 1][j - w[i - 1]] 是除去当前物品总量后能放的总重量
                    int last = v[i - 1][j];
                    int current = val[i - 1] + v[i - 1][j - w[i - 1]];
                    if (current > last) {
                        v[i][j] = current;
                        path[i][j] = 1;
                    } else {
                        v[i][j] = last;
                    }
                    // v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]])
                }
            }
        }

        showArr(v);

        System.out.println("--------");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("放入背包：" + i);
                j -= w[i - 1];
            }
            i--;
        }
    }

    private static void showArr(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%5d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void dynamicPackage() {

    }
}
