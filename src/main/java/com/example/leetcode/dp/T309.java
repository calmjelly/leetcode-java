package com.example.leetcode.dp;

/**
 * @Description: 309. 最佳买卖股票时机含冷冻期
 * @Author: Ybl
 * @Date: 2022/10/21 22:57
 */
public class T309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][3])-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(dp[n-1][1],Math.max(dp[n-1][2],dp[n-1][3]));
    }
}
