package com.calmthinking.leetcode.backtrack;

import java.util.Arrays;

public class T473 {
    int temp;

    public boolean makesquare(int[] matchsticks) {
        //设置一个boolean数组，标记那根火彩用过了。
        //总长度除以4，不能整除那肯定没戏。
        //存在长度大于这个值的，也不行，直接返回false
        //可以整除的话，挨个遍历，传递一个整数，这个值衰减到0，那么给全局计数器+1。同时满足值刷减到0、全局计数器减到0、火柴刚好用完时，返回true
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int edge = sum / 4;
        temp = edge;
        boolean existsOne = Arrays.stream(matchsticks).anyMatch(x -> x > edge);
        if (existsOne) {
            return false;
        }
        boolean[] used = new boolean[matchsticks.length];
        return dfs(matchsticks, edge, 4, used, matchsticks.length);
    }

    private boolean dfs(int[] matchsticks, int edge, int curNum, boolean[] used, int unUsedNum) {
        if (curNum >= 1 && edge == 0) {
            curNum--;
        }
        if (curNum == 0 && edge == 0 && unUsedNum == 0) {
            return true;
        }

        if (curNum >= 1 && edge == 0) {
            edge = temp;
        }

        for (int i = 0; i < matchsticks.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (edge - matchsticks[i] < 0) {
                return false;
            }
            boolean dfs = dfs(matchsticks, edge - matchsticks[i], curNum, used, unUsedNum - 1);
            used[i] = false;
            if (dfs) {
                return true;
            }
        }
        return false;
    }


}
