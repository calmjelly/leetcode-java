package com.calmthinking.leetcode.hash;

/**
 * @Description: 1832. 判断句子是否为全字母句
 * @Author: Ybl
 * @Date: 2022/12/13 0:14
 */
public class T1832 {
    public boolean checkIfPangram(String sentence) {
        if (sentence == null || sentence.length() < 26) {
            return false;
        }
        //用数组模拟哈希表
        boolean[] set = new boolean[26];
        for (char c : sentence.toCharArray()) {
            set[c - 'a'] = true;
        }
        for (boolean x : set) {
            if (!x) {
                return false;
            }
        }
        return true;
    }
}
