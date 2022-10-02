package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Description: 二叉树的层序遍历2
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode node = root;
            queue.offer(node);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode treeNode = queue.poll();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                res.add(list);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
