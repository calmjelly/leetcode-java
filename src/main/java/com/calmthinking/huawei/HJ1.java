package com.calmthinking.huawei;

import java.util.Scanner;

/**
 * @Description: HJ1.字符串最后一个单词的长度
 * @Author: Ybl
 * @Date: 2022/11/15 8:21
 */
public class HJ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int index = str.length() - 1;
        int res = 0;
        while (index >= 0 && str.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && Character.isLetter(str.charAt(index))) {
            res++;
            index--;
        }
        System.out.print(res);

    }
}
