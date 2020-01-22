package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author yiren
 */
public class Main {

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            System.out.println("-------- " + j + " --------");
            // 初始化数据
            long start;
            long end;
            final int len = 1000000;
            int[] bubbleArr = new int[len];

            for (int i = 0; i < len; i++) {
                bubbleArr[i] = (int) (Math.random() * len);
            }
            int[] shellArr2 = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] bubbleArr2 = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] selectArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] insertArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] shellArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] quickArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] mergeArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] radixArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] heapArr = Arrays.copyOf(bubbleArr, bubbleArr.length);

            System.out.println("===> 默认");
            if (len <= 100000) {
                start = System.currentTimeMillis();
                BubbleSort.sort(bubbleArr);
                end = System.currentTimeMillis();
                System.out.println("冒泡: " + (end - start) / 1000.0);

                start = System.currentTimeMillis();
                SelectSort.sort(selectArr);
                end = System.currentTimeMillis();
                System.out.println("选择: " + (end - start) / 1000.0);

                start = System.currentTimeMillis();
                InsertSort.sort(insertArr);
                end = System.currentTimeMillis();
                System.out.println("插入: " + (end - start) / 1000.0);

            }

            start = System.currentTimeMillis();
            ShellSort.sort(shellArr);
            end = System.currentTimeMillis();
            System.out.println("希尔: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            QuickSort.sort(quickArr);
            end = System.currentTimeMillis();
            System.out.println("快排: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            MergeSort.sort(mergeArr);
            end = System.currentTimeMillis();
            System.out.println("归并: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            RadixSort.sort(radixArr);
            end = System.currentTimeMillis();
            System.out.println("基数: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            HeapSort.sort(heapArr);
            end = System.currentTimeMillis();
            System.out.println("堆排序: " + (end - start) / 1000.0);

            System.out.println("===> 优化后");

            if (len <= 100000) {
                start = System.currentTimeMillis();
                BubbleSort.sort2(bubbleArr2);
                end = System.currentTimeMillis();
                System.out.println("冒泡: " + (end - start) / 1000.0);
            }

            start = System.currentTimeMillis();
            ShellSort.sort2(shellArr2);
            end = System.currentTimeMillis();
            System.out.println("希尔: " + (end - start) / 1000.0);

        }
    }
}
