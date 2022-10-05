package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;
/**
 * @Description: 617. 合并二叉树
 * @Author: Ybl
 * @Date: 2022/10/5
 */
public class T617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
        } else if (root1 == null && root2 != null) {
            root.val = root2.val;
        } else if (root1 != null && root2 == null) {
            root.val = root1.val;
        } else {
            return null;
        }
        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root;
    }
}
