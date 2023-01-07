package com.calmthinking.leetcode.two_pointer;

import java.util.Arrays;

/**
 * @Description: 1658. 将 x 减到 0 的最小操作数
 * @Author: Ybl
 * @Date: 2023/1/7 11:09
 */
public class T1658 {

    /**
     * 题目可以转为：从数组中移除一个最长的子数组，使得剩余数组的元素和等于x
     *
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        int left = 0, right = 0, temp = 0, ans = -1;
        for (; right < nums.length; right++) {
            temp += nums[right];
            while (temp > target) {
                temp -= nums[left];
                left++;
            }
            if (temp == target) {
                //要完整的遍历一遍，因为可能有多个子数组都符合条件，要寻找最长的子数组
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : nums.length - ans;
    }
}
