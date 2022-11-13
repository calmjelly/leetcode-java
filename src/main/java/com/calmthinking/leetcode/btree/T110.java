package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 110. 平衡二叉树
 * @Author: Ybl
 * @Date: 2022/10/3
 */
public class T110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean temp = Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        return temp && isBalanced(root.left) && isBalanced(root.right);
    }


    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
