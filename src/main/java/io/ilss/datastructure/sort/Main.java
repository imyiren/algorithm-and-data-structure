package io.ilss.datastructure.sort;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.Arrays;

/**
 * @author feng
 */
public class Main {

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            System.out.println("-------- " + j + " --------");
            // 初始化数据
            long start = 0L;
            long end = 0L;
            int[] bubbleArr = new int[100000];

            for (int i = 0; i < 100000; i++) {
                bubbleArr[i] = (int) (Math.random() * 100000);
            }
            int[] shellArr2 = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] bubbleArr2 = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] selectArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] insertArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] shellArr = Arrays.copyOf(bubbleArr, bubbleArr.length);
            int[] quickArr = Arrays.copyOf(bubbleArr, bubbleArr.length);

            System.out.println("===> 默认");
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

            start = System.currentTimeMillis();
            ShellSort.sort(shellArr);
            end = System.currentTimeMillis();
            System.out.println("希尔: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            QuickSort.sort(quickArr);
            end = System.currentTimeMillis();
            System.out.println("快排: " + (end - start) / 1000.0);

            System.out.println("===> 优化后");
            start = System.currentTimeMillis();
            BubbleSort.sort2(bubbleArr2);
            end = System.currentTimeMillis();
            System.out.println("冒泡: " + (end - start) / 1000.0);

            start = System.currentTimeMillis();
            ShellSort.sort2(shellArr2);
            end = System.currentTimeMillis();
            System.out.println("希尔: " + (end - start) / 1000.0);

        }
    }
}
