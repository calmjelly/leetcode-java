package com.example.leetcode.dp;

/**
 * @Description: 647. 回文子串
 * @Author: Ybl
 * @Date: 2022/10/26 22:54
 */
public class T647 {
    public int countSubstrings(String s) {
        //dp[i][j]定义，区间[i,j]是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //dp[i+1][j-1] -> dp[i][j],所以需要斜着向右上方向推进，也即从下到上，从左到右。
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //case1:i == j,a
                    if (j - i == 0) {
                        dp[i][j] = true;
                    }
                    //case2:回文串长度为2,例如aa
                    else if (j - i == 1) {
                        dp[i][j] = true;
                    }
                    //case3
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
