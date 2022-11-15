package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @Description: 二叉树的层平均值
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return res;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                long total = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode treeNode = queue.poll();
                    total += treeNode.val;
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                res.add(1.0d * total / levelSize);
            }
            return res;
        }
    }
}
