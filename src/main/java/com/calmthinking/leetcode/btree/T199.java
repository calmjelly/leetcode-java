package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @Description: 二叉树的右视图
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> temp = new ArrayList<>();
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
                temp.add(list);
            }
            for (List<Integer> list : temp) {
                res.add(list.get(list.size() - 1));
            }
            return res;
        }
    }
}
