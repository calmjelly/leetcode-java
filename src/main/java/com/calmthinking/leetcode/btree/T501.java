package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 501. 二叉搜索树中的众数
 * @Author: Ybl
 * @Date: 2022/10/6
 */
public class T501 {
    private Set<Integer> set = new HashSet<>();
    private TreeNode preNode = null;
    private int maxNum = -1;
    private int temp = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        help(root);
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (maxNum == -1) {
            temp = 1;
            maxNum = 1;
            set.add(root.val);
        } else {
            if (preNode != null) {
                if (preNode.val == root.val) {
                    temp++;
                    if (temp > maxNum) {
                        maxNum = temp;
                        set.clear();
                        set.add(root.val);
                    } else if (temp == maxNum) {
                        set.add(root.val);
                    }
                } else {
                    temp = 1;
                    if (temp == maxNum) {
                        set.add(root.val);
                    }
                }
            }
        }
        preNode = root;
        help(root.right);
    }
}
