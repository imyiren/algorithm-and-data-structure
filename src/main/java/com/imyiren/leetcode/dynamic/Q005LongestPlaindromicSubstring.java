package com.imyiren.leetcode.dynamic;

/**
 * @author yiren
 */
public class Q005LongestPlaindromicSubstring {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {

        }

        return null;
    }


    public static String longestPalindromeCenter(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len1 =  left - right - 1;
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 =  left - right - 1;

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }



    public static void main(String[] args) {
        System.out.println(longestPalindromeCenter("aacdefcaa"));
    }
}