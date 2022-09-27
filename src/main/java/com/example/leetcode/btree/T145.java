package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

import java.util.*;
/**
 * @Description: 二叉树的后序遍历
 * @Author: Ybl
 * @Date: 2022/9/27
 */
public class T145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            stack.push(root);
            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            Collections.reverse(list);
            return list;
        }
    }
}
