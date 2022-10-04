package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T106 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = new TreeNode();
        root.val = postorder[postorder.length - 1];
        int index =  map.get(root.val) ;
        int leftLen = index;
        root.left = help(inorder, 0, index, postorder, 0, leftLen);
        root.right = help(inorder, index + 1, inorder.length, postorder, leftLen, postorder.length - 1);
        return root;
    }

    private TreeNode help(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inEnd <= inStart || poEnd <= poStart){
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = postorder[poEnd - 1];
        int index = map.get(node.val) ;
        int leftLen = index - inStart;
        if (leftLen < 0){
            return node;
        }
        if (poStart + leftLen <= postorder.length) {
            node.left = help(inorder, inStart, index, postorder, poStart, poStart + leftLen);
            node.right = help(inorder, index + 1, inEnd, postorder, poStart + leftLen , poEnd-1);
        }
        return node;
    }

}
