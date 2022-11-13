package com.calmthinking.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 有多少小于当前数字的数字
 * @Author: Ybl
 * @Date: 2022/11/13 16:46
 */
public class T1365 {
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] tempArr = new int[nums.length];
        System.arraycopy(nums, 0, tempArr, 0, nums.length);
        int[] result = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tempArr);
        for (int i = 0; i < tempArr.length; i++) {
            map.put(tempArr[i], i);
            while (i + 1 < tempArr.length && tempArr[i] == tempArr[i + 1]) {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault(nums[i], 0);
        }
        return result;
    }
}
