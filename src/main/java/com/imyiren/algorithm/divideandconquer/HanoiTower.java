package com.imyiren.algorithm.divideandconquer;

/**
 * @author yiren
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个从" + a + "->" + c);
            return;
        }
        // n>=2
        // 1. 把最上面所有的盘看做一个，A->B， 移动过程会使用到C
        hanoiTower(num - 1, a, c, b);
        // 2. 把最下面的移到c
        System.out.println("第" + num + "个从" + a + "->" + c);
        // 3. 把B的所有盘移到C ： B->C
        hanoiTower(num - 1, b, a, c);
    }
}

