package com.imyiren.swordoffer.q03;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间 O(n) 空间O(n)
 * @author yiren
 */
public class ByMap {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 3, 6, 5, 7};
        System.out.println(repeatNum(arr));
    }


    private static Integer repeatNum(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int item : arr) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                return item;
            }
        }
        return null;
    }

    /**
     *  变体：找出重复元素最多的个数
     * @param arr
     * @return
     */
    private static Integer repeatNumCount(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCountValue = arr[0];
        for (int item : arr) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                int current = map.get(item);
                map.put(item,  + 1);
                if (current > map.get(maxCountValue)) {
                    maxCountValue = item;
                }
            }
        }

        return maxCountValue;

    }


}
