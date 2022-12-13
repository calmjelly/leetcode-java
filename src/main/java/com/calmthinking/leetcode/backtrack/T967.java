package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 967、连续差相同的数字
 * @Author: Ybl
 * @Date: 2022/12/13 8:59
 */
public class T967 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            findValue(list, n, k, i);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    private void findValue(List<Integer> list, int n, int k, int value) {
        if (n <= 1) {
            list.add(value);
            return;
        }
        int pre = value % 10;
        //尝试减去差值
        if (pre - k >= 0) {
            findValue(list, n - 1, k, value * 10 + pre - k);
        }
        //去重，如果k=0，那么 pre-k == pre+k
        if (k == 0) {
            return;
        }
        //尝试加上差值
        if (pre + k < 10) {
            findValue(list, n - 1, k, value * 10 + pre + k);
        }
    }
}
