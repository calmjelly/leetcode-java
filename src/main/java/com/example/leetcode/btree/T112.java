package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

/**
 * @Description: 112. 路径总和
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                return true;
            }
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

}
