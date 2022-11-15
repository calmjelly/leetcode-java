package com.calmthinking.huawei;

import java.util.Scanner;

/**
 * @Description: HJ2 计算某字符出现次数
 * @Author: Ybl
 * @Date: 2022/11/15 22:07
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.next();
        Character cr = target.charAt(0);
        System.out.println(str);
        System.out.println(target);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(cr) || cr.equals(' ')){
                if (cr.equals(str.charAt(i))){
                    res++;
                }
            }else {
                if (Character.toLowerCase(cr) == Character.toLowerCase(str.charAt(i))){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
