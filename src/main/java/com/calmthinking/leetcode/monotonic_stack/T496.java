package com.calmthinking.leetcode.monotonic_stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * @Description:  下一个更大的元素 1
 * @Author: Ybl
 * @Date: 2022/11/13 13:01
 */
public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        //先将nums2的NGE计算出来，存到map中
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                Integer pop = stack.pop();
                map.put(nums2[pop], nums2[i]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                result[i] = -1;
            } else {
                result[i] = map.get(nums1[i]);
            }
        }
        return result;
    }
}
