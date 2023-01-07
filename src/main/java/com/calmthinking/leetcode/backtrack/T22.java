package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 22、括号生成
 * @Author: Ybl
 * @Date: 2023/1/7 16:22
 */
public class T22 {
    /**
     * 1、括号生成是有规则的：任何情况下，右括号的数量都不能大于左括号的数量，可以使用这个条件进行剪枝
     * 2、使用回溯法，每次尝试添加左括号或者右括号，直到左右括号都用完，将结果添加到结果集中
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        backtrack(result, list, n, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, List<Character> list, int n, int lNum, int rNum) {
        if (rNum == n && lNum == n) {
            result.add(charListToString(list));
            return;
        }
        if (rNum > lNum) {
            return;
        }
        if (lNum < n) {
            list.add('(');
            backtrack(result, list, n, lNum + 1, rNum);
            list.remove(list.size() - 1);
        }
        if (rNum < n) {
            list.add(')');
            backtrack(result, list, n, lNum, rNum + 1);
            list.remove(list.size() - 1);
        }
    }

    private String charListToString(List<Character> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining());
    }
}
