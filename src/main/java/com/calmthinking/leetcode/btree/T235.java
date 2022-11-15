package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 235. 二叉搜索树的最近公共祖先
 * @Author: Ybl
 * @Date: 2022/10/7
 */
public class T235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
