package com.calmthinking.leetcode.btree;

import com.calmthinking.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 513. 找树左下角的值
 * @Author: Ybl
 * @Date: 2022/10/4
 */
public class T513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            res = queue.peek().val;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
