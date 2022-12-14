package com.calmthinking.leetcode.dp;

/**
 * @Description: 115. 不同的子序列
 * @Author: Ybl
 * @Date: 2022/10/25 23:22
 */
public class T115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //相等时候，dp[i][j]由两部分组成，可以吧s/t的最后一个元素都去掉来匹配
                    //也可以去掉s的最后一个元素，让s[:-1]来匹配t，
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
