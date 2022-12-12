package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 816、模糊坐标
 * @Author: Ybl
 * @Date: 2022/12/13 0:27
 * 不算回溯，枚举类题目，一次枚举逗号，一次枚举小数点
 */
public class T816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            for (String x : getNums(s.substring(0, i))) {
                for (String y : getNums(s.substring(i))) {
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }
        return result;
    }

    private List<String> getNums(String s) {
        List<String> list = new ArrayList<>();
        String left, right;
        for (int i = 1; i <= s.length(); i++) {
            left = s.substring(0, i);
            right = s.substring(i);
            if ((!"0".equals(left) && left.charAt(0) == '0') || (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) {
                continue;
            }
            if (right.isEmpty()) {
                list.add(left);
            } else {
                list.add( left + '.' + right);
            }
        }
        return list;
    }
}
