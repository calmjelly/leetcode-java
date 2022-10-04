package com.example.leetcode;

import com.example.leetcode.btree.T105;
import com.example.leetcode.btree.T106;

public class Solution {
    public static void main(String[] args) {
        T105 t105 = new T105();
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        t105.buildTree(preorder,inorder);
    }

}
