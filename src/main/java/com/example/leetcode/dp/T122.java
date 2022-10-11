package com.example.leetcode.dp;
/**
 * @Description: 122. 买卖股票的最佳时机 II
 * @Author: Ybl
 * @Date: 2022/10/11 23:21
 */
public class T122 {
    public int maxProfit(int[] prices){
        if(prices == null||prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票的最大收益 = max(第i-1天不持有股票的最大收益，第i-1天持有股票的最大收益+第i天的股票价格)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //第i天持有股票的最大收益 = max(第i-1天持有股票的最大收益，第i-1天不持有股票的最大收益-第i天的股票价格)
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        //最终不持有股票的最大收益即为最大收益
        return dp[prices.length-1][0];
    }
}
