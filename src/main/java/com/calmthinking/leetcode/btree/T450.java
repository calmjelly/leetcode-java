package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 450. 删除二叉搜索树中的节点
 * @Author: Ybl
 * @Date: 2022/10/7
 */
public class T450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left != null && root.right != null) {
                //这种情况，需要将右子树的最左子树，接到pre节点的左子树上
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }

}
