package com.example.leetcode.dp;

import java.util.Arrays;

/**
 * @Description: 674. 最长连续递增序列
 * @Author: Ybl
 * @Date: 2022/10/24 23:42
 */
public class T674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
