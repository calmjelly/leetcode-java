package com.example.leetcode.btree;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 113. 路径总和 II
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, res, list, targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int targetSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        if (root.left != null) {
            dfs(root.left, res, list, targetSum - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, res, list, targetSum - root.val);
            list.remove(list.size() - 1);
        }
    }
}
