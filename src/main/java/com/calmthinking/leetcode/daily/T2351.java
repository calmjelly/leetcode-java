package com.calmthinking.leetcode.daily;

/**
 * @Description: 2351、第一个出现两次的字母
 * @Author: Ybl
 * @Date: 2023/1/8 20:17
 */
public class T2351 {
    public char repeatedCharacter(String s) {
        int[] dic = new int[26];
        for (char c : s.toCharArray()) {
            dic[c - 'a']++;
            if (dic[c - 'a'] == 2){
                return c;
            }
        }
        return ' ';
    }
}
