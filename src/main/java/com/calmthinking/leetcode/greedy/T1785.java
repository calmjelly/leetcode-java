package com.calmthinking.leetcode.greedy;

/**
 * @Description: 构成特定和需要添加的最少元素
 * @Author: Ybl
 * @Date: 2022/12/16 8:47
 */
public class T1785 {
    /**
     * 思路：
     * 1、先计算数组的总和，然后计算数组总和和目标值的差值。
     * 2、得到差值后，选择limit范围内尽可能接近目标值的值（贪心策略）
     * 3、最终结果就是 |差值|%|limit| ==0? |差值|/|limit| : |差值|/|limit|+1
     *
     * @param nums
     * @param limit
     * @param goal
     * @return
     */
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        long needNum = goal - sum;
        long res = Math.abs(needNum) / Math.abs(limit);
        if (Math.abs(needNum) % Math.abs(limit) == 0) {
            return (int) res;
        } else {
            return (int) res + 1;
        }
    }
}
