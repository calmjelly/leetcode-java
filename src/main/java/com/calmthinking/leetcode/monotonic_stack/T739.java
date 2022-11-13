package com.calmthinking.leetcode.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 739. 每日温度
 * @Author: Ybl
 * @Date: 2022/11/10 0:12
 */
public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n  = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
