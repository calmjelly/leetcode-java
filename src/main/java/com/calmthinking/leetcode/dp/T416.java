package com.calmthinking.leetcode.dp;

import java.util.Arrays;

/**
 * @Description: 416.分割等和子集
 * @Author: Ybl
 * @Date: 2022/11/15 22:04
 */
public class T416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - nums[i - 1]] + nums[i - 1]);
                }
                if (dp[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
