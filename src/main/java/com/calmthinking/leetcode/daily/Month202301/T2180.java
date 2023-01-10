package com.calmthinking.leetcode.daily.Month202301;

/**
 * @Description: 2180.统计各位数字之和为偶数的整数个数
 * @Author: Ybl
 * @Date: 2023/1/8 20:13
 */
public class T2180 {
    /**
     * 按照题意模拟即可
     *
     * @param num
     * @return
     */
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }


}
