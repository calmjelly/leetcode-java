package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 电话号码的数字组合
 * @Author: Ybl
 * @Date: 2023/1/7 15:08
 */
public class T17 {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 最终的结果集合里面，每个组合的长度和输入的数字长度一致，每个元素只能对应一个数字。
     * 采用回溯法，
     * 递归方法：
     * 1、返回条件：当组合的元素长度等于数字长度时候，添加到最终结果集并返回。
     * 2、每次取出一个数字，然后转为对应的字母列表，挨个尝试组合。
     * 3、每次尝试完后要还原现场
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        List<Character> list = new ArrayList<>();
        boolean[] used = new boolean[digits.length()];
        backtrack(result, list, digits.toCharArray(), 0);
        return result;
    }

    private void backtrack(List<String> result, List<Character> list, char[] digits, int index) {
        if (index == digits.length) {
            result.add(charArrToString(list));
            return;
        }
        String s = map.get(digits[index]);
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            backtrack(result, list, digits, index + 1);
            list.remove(list.size() - 1);
        }
    }

    private String charArrToString(List<Character> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining());
    }
}
