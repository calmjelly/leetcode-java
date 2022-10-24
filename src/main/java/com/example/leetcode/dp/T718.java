package com.example.leetcode.dp;

/**
 * @Description: 718. 最长重复子数组
 * @Author: Ybl
 * @Date: 2022/10/25 0:08
 */
public class T718 {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j] ：以下标i - 1为结尾的nums1，和以下标j - 1为结尾的nums2，最长重复子数组长度为dp[i][j]
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
