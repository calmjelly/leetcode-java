package com.example.leetcode;

import com.example.leetcode.btree.T106;

public class Solution {
    public static void main(String[] args) {
        T106 t106 = new T106();
        int[] inorder = {2,3,1};
        int[] postorder = {3,2,1};
        t106.buildTree(inorder,postorder);
    }

}
