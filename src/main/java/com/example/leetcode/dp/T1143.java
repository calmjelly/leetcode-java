package com.example.leetcode.dp;
/**
 * @Description: 1143. 最长公共子序列 (LCS问题)
 * @Author: Ybl
 * @Date: 2022/10/25 0:27
 */
public class T1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <=text2.length() ; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    //取最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
       return dp[text1.length()][text2.length()];
    }
}
