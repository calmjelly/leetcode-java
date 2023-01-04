package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 1079.活字印刷
 * @Author: Ybl
 * @Date: 2023/1/4 23:30
 */
public class T1079 {


    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    private int dfs(int[] count) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            res++;
            count[i]--;
            res += dfs(count);
            count[i]++;
        }
        return res;
    }


    /**
     * 方式2：直接输出所有结果集
     * 思路：
     * used数组记录每个位置字符是否被使用过，用于去重
     * 每次调用dfs时候，将当前咱村的list转为字符串，加入结果集
     * 去重有两个地方：
     * 1、当前遍历的字符已经使用了，直接跳过
     * 2、当前遍历的字符和前一个字符相同，且前一个字符没有使用过，直接跳过（将整个结果空间展开，就是同一个分叉的垂直方向上不去重，水平方向去重）
     */
    public int numTilePossibilities2(String tiles) {
        int[] count = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            count[c - 'A']++;
        }
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        char[] chars = tiles.toCharArray();
        boolean[] used = new boolean[chars.length];
        Arrays.sort(chars);
        dfs2(result, list, chars, used);
        return result.size();
    }

    private void dfs2(List<String> result, List<String> list, char[] chars, boolean[] used) {
        if (!list.isEmpty()) {
            result.add(listToString(list));
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            //去重,水平方向去重，同一个分支的垂直方向上不去重
            if (i != 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(String.valueOf(chars[i]));
            dfs2(result, list, chars, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
        return;
    }

    private String listToString(List<String> list) {
        StringBuilder sbr = new StringBuilder();
        for (String str : list) {
            sbr.append(str);
        }
        return sbr.toString();
    }
}
