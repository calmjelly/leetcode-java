package com.calmthinking.leetcode.daily.Month202301;

/**
 * @Description: 1806. 还原排列的最少操作步数
 * @Author: Ybl
 * @Date: 2023/1/9 22:44
 */
public class T1806 {
    public static void main(String[] args) {
        T1806 t = new T1806();

        System.out.println(t.reinitializePermutation(10));
    }

    /**
     * 数学题就完全不会。。
     * 直接按照题意模拟吧
     *
     * @param n
     * @return
     */
    public int reinitializePermutation(int n) {
        int[] init = new int[n];
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = i;
            init[i] = i;
        }
        int num = 0;
        do {
            System.arraycopy(cur, 0, pre, 0, n);
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    cur[i] = pre[i / 2];
                } else {
                    cur[i] = pre[n / 2 + (i - 1) / 2];
                }
            }
            num++;
        } while (!checkEqual(init, cur));

        return num;
    }

    private boolean checkEqual(int[] num1, int[] num2) {
        if (num1.length != num2.length) {
            return false;
        }
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }

}
