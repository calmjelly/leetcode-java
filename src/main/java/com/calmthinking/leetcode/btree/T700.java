package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 700. 二叉搜索树中的搜索
 * @Author: Ybl
 * @Date: 2022/10/5
 */
public class T700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        } else if (root.val > val) {
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }
}
