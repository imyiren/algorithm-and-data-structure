package com.imyiren.datastructure.sort;

import java.util.Arrays;

/**
 * @author yiren
 */
public class RadixSort {


    public static void sort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLen = String.valueOf(max).length();
        int n = 1;
        for (int count = 0; count < maxLen; n *= 10, count++) {
            int[][] bucket = new int[10][arr.length];
            int[] bucketSize = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;
                bucket[digit][bucketSize[digit]++] = arr[i];
            }
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    arr[idx] = bucket[i][j];
                    idx++;
                }
            }
        }
    }

    public static void sort2(int[] arr) {
        for (int n = 1; true; n *= 10) {
            int[][] bucket = new int[10][arr.length];
            int[] bucketSize = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;
                bucket[digit][bucketSize[digit]++] = arr[i];
            }
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    arr[idx] = bucket[i][j];
                    idx++;
                }
            }
            // 这个结束条件要多跑一轮
            if (bucketSize[0] == arr.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{31, 12, 23, 3, 54, 6, 72, 9, 3, 41, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        test(1000);
        test(10000);
        test(100000);
        test(1000000);
        test(10000000);
        test(20000000);
        test(30000000);
        test(40000000);
        test(50000000);

        // test(60000000);
        // test(70000000);
        // test(80000000);
        // test(90000000);
        // test(100000000);
        // System.out.println("...");
        // 注意会堆内存溢出

    }

    public static void test(int n) {
        int[] radixArr = new int[n];
        for (int i = 0; i < n; i++) {
            radixArr[i] = (int) (Math.random() * n * 10);
        }
        long start = System.currentTimeMillis();
        sort(radixArr);
        long end = System.currentTimeMillis();
        System.out.println("n: " + n + ", 耗时" + (end - start) / 1000.0);
    }
}

/**
 * /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/bin/java -Xmx5000m "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=60807:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/lib/tools.jar:/Users/yiren/Projects/java/data-structure/target/classes:/Users/yiren/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:/Users/yiren/.m2/repository/ch/qos/logback/logback-core/1.1.11/logback-core-1.1.11.jar:/Users/yiren/.m2/repository/ch/qos/logback/logback-classic/1.1.11/logback-classic-1.1.11.jar io.ilss.datastructure.sort.RadixSort
 * [3, 3, 5, 6, 6, 9, 12, 23, 31, 41, 54, 72]
 * n: 1000, 耗时0.0
 * n: 10000, 耗时0.003
 * n: 100000, 耗时0.016
 * n: 1000000, 耗时0.106
 * n: 10000000, 耗时1.667
 * n: 20000000, 耗时3.016
 * n: 30000000, 耗时4.245
 * n: 40000000, 耗时6.846
 * n: 50000000, 耗时7.588
 * <p>
 * Process finished with exit code 130 (interrupted by signal 2: SIGINT)
 */
