package com.calmthinking.leetcode.weekly_contest.wk_327;
/**
 * @Description: 6284. 使字符串总不同字符的数目相等
 * @Author: Ybl
 * @Date: 2023/1/8 12:28
 */
public class T6284 {

    /**
     * 万万没想到，竟然这个题的解法是暴力枚举，我朝着DP的方向想了半天，草
     *
     * @param word1
     * @param word2
     * @return
     */
    public boolean isItPossible(String word1, String word2) {
        int[] word1Arr = new int[26];
        int[] word2Arr = new int[26];

        for (char c : word1.toCharArray()) {
            word1Arr[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (word1Arr[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (word2Arr[j] > 0) {
                        //交换字符
                        word1Arr[i]--;
                        word1Arr[j]++;
                        word2Arr[j]--;
                        word2Arr[i]++;
                        //检查交换后是否符合需求
                        if (check(word1Arr, word2Arr)) {
                            return true;
                        }
                        //还原
                        word1Arr[i]++;
                        word1Arr[j]--;
                        word2Arr[j]++;
                        word2Arr[i]--;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int[] word1Arr, int[] word2Arr) {
        int x = 0, y = 0;
        for (int i = 0; i < 26; i++) {
            if (word1Arr[i] > 0) {
                x++;
            }
            if (word2Arr[i] > 0) {
                y++;
            }
        }
        return x == y;
    }
}
