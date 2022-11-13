package com.calmthinking.leetcode.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 接雨水
 * @Author: Ybl
 * @Date: 2022/11/13 13:35
 */
public class T42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ngeArr = new int[height.length];
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int stackTop = stack.peek();
            if (height[i] < height[stackTop]) {
                stack.push(i);
            } else if (height[i] == height[stackTop]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stackTop] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left],height[i]) -height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0){
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
