package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 108. 将有序数组转换为二叉搜索树
 * @Author: Ybl
 * @Date: 2022/10/7
 */
public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid - 1);
        node.right = help(nums, mid + 1, nums.length - 1);
        return node;
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left > right || right >= nums.length) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid - 1);
        node.right = help(nums, mid + 1, right);
        return node;
    }
}
