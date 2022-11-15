package com.calmthinking.leetcode.dp;

/**
 * @Description: 413.等差数列划分
 * @Author: Ybl
 * @Date: 2022/11/15 21:12
 */
public class T413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum = sum + dp[i];
            } else {
                dp[i] = 0;
            }
        }
        return sum;
    }
}
