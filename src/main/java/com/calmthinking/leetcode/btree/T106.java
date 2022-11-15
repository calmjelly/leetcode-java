package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T106 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        int index = map.get(root.val);
        int leftLen = index;
        root.left = help(inorder, 0, index, preorder, 1, 1 + leftLen);
        root.right = help(inorder, index + 1, inorder.length, preorder, 1 + leftLen, preorder.length);
        return root;
    }

    private TreeNode help(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inEnd < inStart || preEnd < preStart) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[preStart];
        int index = map.get(root.val);
        int leftLen = index-inStart;
        if (leftLen < 0) {
            return null;
        }
        if (preStart + leftLen +1 < preorder.length) {
            root.left = help(inorder, inStart, index, preorder, preStart + 1, preStart + leftLen+1);
            root.right = help(inorder, index + 1, inEnd, preorder, preStart + leftLen +1, preEnd);
        }
        return root;
    }

}
