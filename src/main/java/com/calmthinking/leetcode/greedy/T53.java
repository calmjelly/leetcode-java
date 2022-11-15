package com.calmthinking.leetcode.greedy;

/**
 * @Description: 53.最大子数组和
 * @Author: Ybl
 * @Date: 2022/11/15 22:41
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curVal < 0) {
                curVal = nums[i];
            } else {
                curVal += nums[i];
            }
            res = Math.max(curVal, res);
        }
        return res;
    }
}
