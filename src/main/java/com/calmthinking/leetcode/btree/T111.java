package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 二叉树的最小深度
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left != null && root.right == null) {
                return 1 + minDepth(root.left);
            }
            if (root.right != null && root.left == null) {
                return 1 + minDepth(root.right);
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
