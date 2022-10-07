package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

/**
 * @Description: 236. 二叉树的最近公共祖先
 * @Author: Ybl
 * @Date: 2022/10/7
 */
public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return root;
        }
    }
}
