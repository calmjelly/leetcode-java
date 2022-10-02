package com.example.leetcode.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @Description: N叉树的层序遍历
 * @Author: Ybl
 * @Date: 2022/10/2
 */
public class T429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null){
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int levelSize = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();
                    list.add(node.val);
                    if (node.children!=null){
                        for (Node child : node.children){
                            queue.offer(child);
                        }
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}
