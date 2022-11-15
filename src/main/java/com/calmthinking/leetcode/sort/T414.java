package com.calmthinking.leetcode.sort;
/**
 * @Description: 第三大的数
 * @Author: Ybl
 * @Date: 2022/11/15 22:57
 */
public class T414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long one = Long.MIN_VALUE;
        long two = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > one) {
                three = two;
                two = one;
                one = cur;
            } else if (cur > two && cur < one) {
                three = two;
                two = cur;
            } else if (cur > three && cur < two) {
                three = cur;
            }
        }
        return (int) (three == Long.MIN_VALUE ? one : three);
    }
}
