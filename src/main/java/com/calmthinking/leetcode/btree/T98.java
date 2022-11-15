package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

/**
 * @Description: 98. 验证二叉搜索树
 * @Author: Ybl
 * @Date: 2022/10/5
 */
public class T98 {
    private Long preValue =Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val<=preValue){
            return false;
        }
        preValue = (long)root.val;
        if (!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
