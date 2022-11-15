package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 257. 二叉树的所有路径
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        return list;
    }

    private void dfs(TreeNode root, String s, List<String> list) {
        if (root == null) {
            return;
        }
        s = s + root.val + "->";
        if (root.left == null && root.right == null) {
            list.add(s.substring(0, s.length() - 2));
            return;
        }
        dfs(root.left,s,list);
        dfs(root.right,s,list);
    }
}
