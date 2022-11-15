package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的前序遍历
 * @Author: Ybl
 * @Date: 2022/9/27
 */
public class T144 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root == null){
                return list;
            }
            stack.push(root);
            while (stack.size()>0){
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }
            return list;
        }
    }
}
