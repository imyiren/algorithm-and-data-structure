package com.imyiren.algorithm.kmp;

import java.util.Arrays;

/**
 * @author yiren
 */
public class MatchString {
    public static void main(String[] args) {
        String str = "123 451231 451";
        String target = "4512312";
        String target2 = "aa";
        matchKmp("", "ABCDABD");
        // System.out.println(matchViolence(str, target));
    }

    /**
     * 暴力匹配算法
     *
     * @param str    原串
     * @param target 子串
     * @return 匹配初始位置 -1为没有匹配到
     */
    private static int matchViolence(String str, String target) {
        // 如果不不成功会一直循环到结束再退出成功的条件就是j++到了s2Len。
        int i = 0, j = 0;
        while (i < str.length() && j < target.length()) {
            // 剩余长度不够了就直接返回就可以
            if (str.length() - i < target.length()) {
                return -1;
            }
            // 只要匹配到相等就++
            if (str.charAt(i) == target.charAt(i)) {
                i++;
                j++;
                //如果不等了就把i回退到当前匹配的第一个的下一个位置 j则置零
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        // 判断是否匹配成功
        return j == target.length() ? i - j : -1;
    }

    /**
     * kmp匹配算法
     *
     * @param str    原串
     * @param target 子串
     * @return 匹配初始位置 -1为没有匹配到
     */
    private static int matchKmp(String str, String target) {
        // 先得到部分匹配表
        // 创建一个数组来保存部分匹配值
        int[] next = new int[target.length()];
        // 如果target长度为1，部分匹配值就是0
        next[0] = 0;
        for (int i = 1, j = 0; i < target.length(); i++) {

            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            // 满足如下条件，部分匹配值就需要+1
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        // 利用部分匹配表来处理匹配
        for (int i = 0, j = 0; i < str.length(); i++) {
            // 需要处理不相等的时候，去调整j的大小，KMP算法的核心。
            while (j > 0 && str.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            // 只要匹配到相等就++
            if (str.charAt(i) == target.charAt(j)) {
                j++;
            }
            // 如果两个相等
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
