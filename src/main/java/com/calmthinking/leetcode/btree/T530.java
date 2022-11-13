package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

/**
 * @Description: 530. 二叉搜索树的最小绝对差
 * @Author: Ybl
 * @Date: 2022/10/6
 */
public class T530 {
    //二叉搜索树的中序遍历是单调递增的,所以在中序遍历的过程中，
    // 记录前一个节点的值,然后和当前节点的值做差,取最小值即可

    private int preValue = -1;
    private int minValue = Integer.MAX_VALUE;


    public int getMinimumDifference(TreeNode root) {
        help(root);
        return minValue == Integer.MAX_VALUE ? 0 : minValue;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        //第一个节点不更新
        if (preValue != -1) {
            minValue = Math.min(minValue, root.val - preValue);
        }
        preValue = root.val;
        help(root.right);
    }
}
