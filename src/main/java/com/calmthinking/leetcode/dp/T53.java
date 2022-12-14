package com.calmthinking.leetcode.dp;

/**
 * @Description: 53. 最大子序和
 * @Author: Ybl
 * @Date: 2022/10/25 22:28
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
