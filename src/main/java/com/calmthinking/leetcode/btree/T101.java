package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

public class T101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return help(root.left, root.right);
        }


        private boolean help(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            }else if (left.val != right.val){
                return false;
            }
            return help(left.left,right.right) && help(left.right,right.left);
        }
    }
}
