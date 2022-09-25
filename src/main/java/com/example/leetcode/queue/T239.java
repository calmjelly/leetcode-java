package com.example.leetcode.queue;

import java.util.*;

/**
 * @Description: 239.滑动窗口的最大值
 * @Author: Ybl
 * @Date: 2022/9/25
 */
public class T239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MyQueue myQueue = new MyQueue();
            //其实不用list也行，数组长度一开始就可以确定了
            List<Integer> list = new ArrayList<>();
            //先构建队列
            for (int i = 0; i < k; i++) {
                myQueue.offer(nums[i]);
            }
            list.add(myQueue.peek());
            for (int i = k; i <nums.length; i++) {
                myQueue.offer(nums[i]);
                if (myQueue.peek() == nums[i-k]){
                    myQueue.poll();
                }
                list.add(myQueue.peek());
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

    }

    class MyQueue {
        private Deque<Integer> deque;

        public MyQueue() {
            deque = new LinkedList<>();
        }

        public void offer(Integer x) {
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast();
            }
            deque.offer(x);
        }

        public Integer poll() {
            return deque.poll();
        }

        public Integer peek() {
            return deque.peek();
        }

        public int size() {
            return deque.size();
        }
    }
}