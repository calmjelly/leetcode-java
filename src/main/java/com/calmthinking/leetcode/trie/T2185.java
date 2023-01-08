package com.calmthinking.leetcode.trie;

/**
 * @Description: 2185、统计包含给定前缀的字符串
 * @Author: Ybl
 * @Date: 2023/1/8 15:47
 */
public class T2185 {
    public static void main(String[] args) {
        T2185 t = new T2185();
        String[] words = {"lewsmb","lewrydnve","lewqqm","lewec","lewn","lewb","lewedb"};
        String prefixes = "lew";
        int res = t.prefixCount(words, prefixes);
        System.out.println(res);

    }

    /**
     * 字典树解法，要对字典树进行一些略微的修改，使其能够统计以某个前缀开头的单词数量
     * 修改点：每次遍历单词时，不仅仅只在最后一个节点计数，在之前经过的节点，都要进行累加的操作
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        return trie.query(pref);
    }


    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public class TrieNode {
            TrieNode[] children;
            int cnt;

            public TrieNode() {
                children = new TrieNode[26];
                cnt = 0;
            }
        }

        void add(String str) {
            TrieNode p = root;
            for (char c : str.toCharArray()) {
                int u = c - 'a';
                if (p.children[u] == null) {
                    p.children[u] = new TrieNode();
                }
                p.cnt++;
                p = p.children[u];
            }
            p.cnt++;
        }

        int query(String str) {
            TrieNode p = root;
            for (char c : str.toCharArray()) {
                int u = c - 'a';
                if (p.children[u] == null) {
                    return 0;
                }
                p = p.children[u];
            }
            return p.cnt;
        }
    }


    //-------------暴力解法-------------
    public int prefixCount2(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }

}
