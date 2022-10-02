package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 515. 在每个树行中找最大值
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode node = root;
            queue.offer(node);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode treeNode = queue.poll();
                    maxValue = Math.max(maxValue, treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                res.add(maxValue);
            }
            return res;
        }
    }
}
