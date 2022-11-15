package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 翻转二叉树
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return root;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }
    }
}
