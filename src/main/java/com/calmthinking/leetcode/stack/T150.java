package com.calmthinking.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 * 逆波兰表达式求值
 */
public class T150 {


    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                //注意这里，第一次做的时候写反了
                Integer num2 = Integer.valueOf(stack.pop());
                Integer num1 = Integer.valueOf(stack.pop());
                Integer num3 = calculate(num1, num2, token);
                stack.push(String.valueOf(num3));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private Integer calculate(Integer num1, Integer num2, String token) {
        switch (token) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        throw new IllegalStateException();
    }

}
