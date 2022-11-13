package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 654. 最大二叉树
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T654 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int index = findMaxValueIndex(nums, 0, nums.length);
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, 0, index);
        root.right = dfs(nums, index + 1, nums.length);
        return root;
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int index = findMaxValueIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = dfs(nums, start, index);
        node.right = dfs(nums, index + 1, end);
        return node;
    }


    private int findMaxValueIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return map.get(max);
    }
}
