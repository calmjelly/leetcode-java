package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

/**
 * @Description: 404. 左叶子之和
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T404 {
    private  int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum+=root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
