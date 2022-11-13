package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 669. 修剪二叉搜索树
 * @Author: Ybl
 * @Date: 2022/10/7
 */
public class T669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            TreeNode node = trimBST(root.right, low, high);
            return node;
        }
        if (root.val > high) {
            TreeNode node = trimBST(root.left, low, high);
            return node;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
