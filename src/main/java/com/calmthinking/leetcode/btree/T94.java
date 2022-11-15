package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的中序遍历
 * @Author: Ybl
 * @Date: 2022/9/27
 */
public class T94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pointer = root;
            while (pointer != null || !stack.isEmpty()) {
                if (pointer != null) {
                    stack.push(pointer);
                    pointer = pointer.left;
                }else {
                    pointer = stack.pop();
                    list.add(pointer.val);
                    pointer = pointer.right;
                }
            }
            return list;
        }

    }
}
