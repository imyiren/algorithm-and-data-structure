package io.ilss.datastructure.sort;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * @author feng
 */
public class Main {

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            System.out.println("----> " + j);
            // 初始化数据
            long start = 0L;
            long end = 0L;
            int[] bubbleArr = new int[80000];
            int[] bubbleArr2 = new int[80000];
            int[] selectArr = new int[80000];
            int[] insertArr = new int[80000];
            for (int i = 0; i < 80000; i++) {
                bubbleArr[i] = (int) (Math.random() * 80000);
                bubbleArr2[i] = (int) (Math.random() * 80000);
                selectArr[i] = (int) (Math.random() * 80000);
                insertArr[i] = (int) (Math.random() * 80000);
            }

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

            System.out.println("===> 优化后");
            start = System.currentTimeMillis();
            BubbleSort.sort2(bubbleArr);
            end = System.currentTimeMillis();
            System.out.println("冒泡: " + (end - start) / 1000.0);
        }
    }
}
