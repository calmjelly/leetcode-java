package com.calmthinking.leetcode.weekly_contest.wk_327;

/**
 * @Description: 正整数和负整数的最大计数
 * @Author: Ybl
 * @Date: 2023/1/8 10:32
 */
public class T6283 {
    public static void main(String[] args) {
        T6283 t = new T6283();
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(t.maximumCount(nums));
    }


    /**
     * 按照题意模拟即可
     *
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        //正整数和负整数的最大计数
        if (nums.length == 0) {
            return 0;
        }
        if (nums[nums.length - 1] == 0 || nums[0] == 0) {
            return 0;
        }
        if (nums[nums.length - 1] < 0 || nums[0] > 0) {
            return nums.length;
        }
        //遍历，计算正整数和负整数的最大计数
        int pos = 0, neg = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;

            } else if (nums[i] < 0) {
                neg++;

            }
        }
        max = Math.max(pos, neg);
        return max;

    }

}
