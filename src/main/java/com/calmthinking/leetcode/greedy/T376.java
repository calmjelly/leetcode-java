package com.calmthinking.leetcode.greedy;

/**
 * @Description: 376.摆动序列
 * @Author: Ybl
 * @Date: 2022/11/15 22:37
 */
public class T376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 1;
        }
        if (n == 2 && nums[0] != nums[1]) {
            return 2;
        }

        int preDiff = nums[1] - nums[0];
        int res = preDiff == 0 ? 1 : 2;
        int curDiff = 0;
        for (int i = 2; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && curDiff < 0) || (curDiff > 0 && preDiff <= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
