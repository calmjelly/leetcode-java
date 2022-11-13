package com.calmthinking.leetcode.greedy;

import java.util.Arrays;

/**
 * @Description: 455.分发饼干
 * @Author: Ybl
 * @Date: 2022/11/13 17:14
 */
public class T455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {

            if (s[index] >= g[i]) {
                index--;
                res++;
                if (index < 0) {
                    break;
                }
            }
        }
        return res;
    }
}
