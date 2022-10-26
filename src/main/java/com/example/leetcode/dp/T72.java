package com.example.leetcode.dp;

/**
 * @Description: 72. 编辑距离
 * @Author: Ybl
 * @Date: 2022/10/26 11:11
 */
public class T72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //如果相等，则和i-1,j-1的值是相同的
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果不等，那么要么word1新增一个？word1去掉一个？word1修改一个？
                    // 可以把word1新增改为word2减少
                    //从左至右依次是：word2减少，word1减少，word1修改
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
