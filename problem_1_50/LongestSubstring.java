package com.kzl.leetcode.problem_1_50;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 1;
        if (s.length() == 0)
            return 0;
        String temp = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (temp.indexOf(s.charAt(i)) == -1 && s.charAt(i - 1) != s.charAt(i)) {
                temp += s.charAt(i);
            } else {
                if (temp.indexOf(s.charAt(i)) != -1) {
                    temp = temp.substring(temp.indexOf(s.charAt(i)) + 1, temp.length());
                    temp += s.charAt(i);
                } else {
                    temp = "" + s.charAt(i - 1);
                }
            }
            if (ans < temp.length()) {
                ans = temp.length();
            }
        }
        return ans;
    }
}
