package com.calmthinking.huawei;

import java.util.Scanner;

/**
 * @Description: HJ4 字符串分隔
 * @Author: Ybl
 * @Date: 2022/11/16 8:19
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() == 0) {
            return;
        }
        int n = str.length();
        if (n < 8) {
            System.out.println(str + "00000000".substring(n));
            return;
        }
        int segment = n / 8;
        int num = n % 8;
        for (int i = 0; i <= segment - 1; i++) {
            System.out.println(str.substring(i * 8, (i + 1) * 8));
        }
        if (num != 0) {
            System.out.println(str.substring(8 * (segment)) + "00000000".substring(num));
        }
    }
}
