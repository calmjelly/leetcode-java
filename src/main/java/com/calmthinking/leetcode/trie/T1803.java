package com.calmthinking.leetcode.trie;

/**
 * @Description: 1803. 统计异或值在范围内的数对有多少
 * @Author: Ybl
 * @Date: 2023/1/5 23:47
 */
public class T1803 {

    class Trie {
        private Trie[] children = new Trie[2];
        private int cnt;

        public void insert(int x) {
            Trie node = this;
            for (int i = 15; i >= 0; --i) {
                int v = (x >> i) & 1;
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
                ++node.cnt;
            }
        }

        public int search(int x, int limit) {
            Trie node = this;
            int ans = 0;
            for (int i = 15; i >= 0 && node != null; --i) {
                int v = (x >> i) & 1;
                if (((limit >> i) & 1) == 1) {
                    if (node.children[v] != null) {
                        ans += node.children[v].cnt;
                    }
                    node = node.children[v ^ 1];
                } else {
                    node = node.children[v];
                }
            }
            return ans;
        }
    }

    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            Trie trie = new Trie();
            int ans = 0;
            for (int x : nums) {
                ans += trie.search(x, high + 1) - trie.search(x, low);
                trie.insert(x);
            }
            return ans;
        }
    }

}
