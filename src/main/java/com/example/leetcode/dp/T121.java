package com.example.leetcode.dp;

/**
 * @Description: 121. 买卖股票的最佳时机
 * @Author: Ybl
 * @Date: 2022/10/8 15:15
 */
public class T121 {
    //贪心
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min != Integer.MAX_VALUE) {
                res = Math.max(res, prices[i] - min);
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return res;
    }

    //dp
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //dp[i][0]表示第i天不持有股票的最大利润
        //dp[i][1]表示第i天持有股票的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票的最大利润 = max(第i-1天不持有股票的最大利润，第i-1天持有股票的最大利润+第i天的股票价格)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第i天持有股票的最大利润 = max(第i-1天持有股票的最大利润，-第i天的股票价格)
            //因为只能买卖一次，所以第i天持有股票的最大利润只能是第i-1天持有股票的最大利润或者第i天买入股票
            dp[i][1] = Math.max(dp[i - 1][1],- prices[i]);
        }
        //最后一天不持有股票的最大利润即为最大利润
        return dp[prices.length-1][0];
    }


}
