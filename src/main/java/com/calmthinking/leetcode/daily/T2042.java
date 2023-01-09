package com.calmthinking.leetcode.daily;

/**
 * @Description: 2042、检查句子中的数字是否递增
 * @Author: Ybl
 * @Date: 2023/1/8 23:26
 */
public class T2042 {
    public boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int pre = -1;
        for (String str : strings) {
            int flag = str.charAt(0) - '0';
            if (flag >= 0 && flag <= 9) {
                int cur = Integer.parseInt(str);
                if (pre >= cur) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }

    /**
     * 不使用java的parseInt、split函数
     *
     * @param s
     * @return
     */
    public boolean areNumbersAscending2(String s) {
        int pre = 0, pos = 0;
        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos))) {
                int cur = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    cur = cur * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            } else {
                pos++;
            }
        }
        return true;
    }
}
