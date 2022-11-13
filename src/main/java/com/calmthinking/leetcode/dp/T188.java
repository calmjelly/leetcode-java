package com.calmthinking.leetcode.dp;

/**
 * @Description: 188. 买卖股票的最佳时机 IV
 * @Author: Ybl
 * @Date: 2022年10月19日23:48:25
 */
public class T188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = -prices[0];
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
