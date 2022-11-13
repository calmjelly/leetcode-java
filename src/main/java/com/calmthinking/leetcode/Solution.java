package com.calmthinking.leetcode;

import com.calmthinking.leetcode.monotonic_stack.T496;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        T496 t105 = new T496();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(t105.nextGreaterElement(nums1,nums2))); ;
    }

}
