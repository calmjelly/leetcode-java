package com.calmthinking.leetcode.monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 下一个更大的元素2
 * @Author: Ybl
 * @Date: 2022/11/13 13:02
 */
public class T503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int pop = stack.pop();
                result[pop] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int pop = stack.pop();
                result[pop] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
