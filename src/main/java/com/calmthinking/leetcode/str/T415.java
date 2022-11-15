package com.calmthinking.leetcode.str;

/**
 * @Description: 415.字符串相加
 * @Author: Ybl
 * @Date: 2022/11/15 22:57
 */
public class T415 {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sbr = new StringBuilder();
        while (index2 >= 0 || index1 >= 0) {
            int num1val = 0;
            int num2val = 0;
            int tempSum = 0;
            if (index1 >= 0) {
                num1val = num1.charAt(index1) - '0';
            }
            if (index2 >= 0) {
                num2val = num2.charAt(index2) - '0';
            }
            tempSum = (num1val + num2val) + carry;
            index1--;
            index2--;
            sbr.append(tempSum % 10);
            carry = tempSum / 10;
        }
        if (carry > 0) {
            sbr.append(carry);
        }
        return sbr.reverse().toString();
    }
}
