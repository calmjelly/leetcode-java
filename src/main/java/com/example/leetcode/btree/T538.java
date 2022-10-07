package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

/**
 * @Description: 538. 把二叉搜索树转换为累加树
 * @Author: Ybl
 * @Date: 2022/10/7 23:32
 */
public class T538 {
    private TreeNode pre;

    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        help(node);
        return root;

    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        if (pre != null) {
            root.val = root.val + pre.val;
        }
        pre = root;
        convertBST(root.left);
    }
}
