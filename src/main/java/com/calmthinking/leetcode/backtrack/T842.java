package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 842、将数组拆分成斐波那契序列
 * @Author: Ybl
 * @Date: 2022/12/13 8:26
 */
public class T842 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        dfs(result, num, 0);
        return result;
    }

    private boolean dfs(List<Integer> result, String num, int start) {
        if (result.size() >= 3 && start == num.length()) {
            return true;
        }
        for (int i = start + 1; i <= num.length(); i++) {
            //如果开头是0，并且这不是第一个数字，例：'01'，就不用继续往后搜索了
            if (num.charAt(start) == '0' && i > start + 1) {
                break;
            }
            long temp = Long.parseLong(num.substring(start, i));
            if (temp > Integer.MAX_VALUE) {
                break;
            }
            //继续递归的条件：要么结果集小于2，要么满足斐波那契的数列的条件
            if (result.size() <= 1 || temp == result.get(result.size() - 1) + result.get(result.size() - 2)) {
                result.add((int) temp);
                //一旦找到任意一个结果集，打断回溯，提前终止
                if (dfs(result, num, i)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T842 t842 = new T842();
        List<Integer> integers = t842.splitIntoFibonacci("123456579");
        System.out.println(integers);
    }
}
