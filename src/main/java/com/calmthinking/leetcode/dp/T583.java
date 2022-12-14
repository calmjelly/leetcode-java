package com.calmthinking.leetcode.dp;

/**
 * @Description: 583. 两个字符串的删除操作
 * @Author: Ybl
 * @Date: 2022/10/26 0:43
 */
public class T583 {
        public int minDistance(String word1, String word2) {
            //转为求最大的公共子序列
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        //注意这里，要取两者的最大值
                        dp[i][j] = Math.max(dp[i][j - 1],dp[i-1][j]);
                    }
                }
            }
            return word1.length() + word2.length() - 2*dp[word1.length()][word2.length()];
        }
}
