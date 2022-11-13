package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 二叉树的最大深度
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
