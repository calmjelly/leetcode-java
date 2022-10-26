package com.example.leetcode.dp;

import java.util.Arrays;

/**
 * @Description: 392. 判断子序列
 * @Author: Ybl
 * @Date: 2022/10/25 22:43
 */
public class T392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        //dp[i][j] 表示以下标i为结尾的字符串s，
        // 和以下标j为结尾的字符串t，s是否是t的子序列
        //可以看到，这样初始化比较复杂。。还是表示[0,i-1]这个区间比较好
        boolean[][] dp = new boolean[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        Arrays.fill(dp[0], true);
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(0) == t.charAt(i)) {
                break;
            } else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }


    public boolean isSubsequence2(String s, String t) {
        //dp[i][j]表示以下标i-1为结尾的字符串s,和以下标j-1的
        //字符串t，相同子序列的长度为dp[i][j]
        //不表示下标为i，是为了方便递推，避免初始化过于复杂。
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length() ; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

}
