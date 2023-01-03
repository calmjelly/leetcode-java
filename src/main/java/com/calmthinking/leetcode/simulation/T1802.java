package com.calmthinking.leetcode.simulation;

/**
 * @Description: 有界数组中指定下标处的最大值
 * @Author: Ybl
 * @Date: 2023/1/4 0:20
 */
public class T1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left = index;
        int right = index;
        int ans = 1;
        int rest = maxSum - n;
        while (left > 0 || right < n - 1) {
            int len = right - left + 1;
            if (rest >= len) {
                rest -= len;
                ans++;
                left = Math.max(0, left - 1);
                right = Math.min(n - 1, right + 1);
            } else {
                break;
            }
        }
        ans += rest / n;
        return ans;
    }
}
