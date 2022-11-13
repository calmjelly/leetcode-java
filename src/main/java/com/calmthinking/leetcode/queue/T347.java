package com.calmthinking.leetcode.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description: 前K个高频元素
 * @Author: Ybl
 * @Date: 2022/9/25
 */
public class T347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            //默认大顶堆，这里需要使用小顶堆
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, (x, y) -> y[1] - x[1]);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int[] valueArr = new int[2];
                valueArr[0] = entry.getKey();
                valueArr[1] = entry.getValue();
                priorityQueue.add(valueArr);
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = priorityQueue.poll()[0];
            }
            return result;
        }
    }
}
