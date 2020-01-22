package com.imyiren.datastructure.recursion;

import lombok.Getter;
import lombok.ToString;

/**
 * @author yiren
 */
@ToString
public class EightQueens {
    private int max = 8;
    private int[] arr = new int[max];
    @Getter
    private int count = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println("count: " + eightQueens.getCount());
    }

    private void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n] 是否在同一列
            // Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 是否在同一斜线上
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    // 放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        // 依次放入 并判断是否冲突
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
}
