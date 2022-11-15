package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 222. 完全二叉树的节点个数
 * @Author: Ybl
 * @Date: 2022/10/3
 */
public class T222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
