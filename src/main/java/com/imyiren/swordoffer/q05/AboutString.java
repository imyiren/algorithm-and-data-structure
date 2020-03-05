package com.imyiren.swordoffer.q05;

/**
 * @author yiren
 */
public class AboutString {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = "hello world";
        System.out.println(str1 == str2);
        String str3 = new String("hello world");
        System.out.println(str3 == str1);
        System.out.println(str3.equals(str2));
    }
}
