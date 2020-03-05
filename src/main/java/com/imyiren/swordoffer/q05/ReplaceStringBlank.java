package com.imyiren.swordoffer.q05;


/**
 * @author yiren
 */
public class ReplaceStringBlank {
    public static void main(String[] args) {
        char[] str = "123 apple 123 s".toCharArray();
        System.out.println(new String(replace1(str)));
        char[] str2 = new char[str.length * 3];
        for (int i = 0; i < str.length; i++) {
            str2[i] = str[i];
        }
        replace2(str2);
        System.out.println(new String(str2));

    }

    /**
     * 使用新数组
     *
     * @param str
     */
    private static char[] replace1(char[] str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                builder.append("%20");
            } else {
                builder.append(str[i]);
            }
        }
        return builder.toString().toCharArray();
    }


    /**
     * 使用原数组
     *
     * @param str
     */
    private static void replace2(char[] str) {
        int blankCount = 0;
        for (int i = 0; i < str.length / 3; i++) {
            if (' ' == str[i]) {
                blankCount++;
            }
        }
        int rightIndex = str.length / 3 - 1 + blankCount * 2;
        for (int i = str.length / 3 - 1; i >= 0; i--) {

            if (str[i] == ' ') {
                str[rightIndex--] = '0';
                str[rightIndex--] = '2';
                str[rightIndex--] = '%';
            } else {
                str[rightIndex--] = str[i];
            }
        }

    }


}
