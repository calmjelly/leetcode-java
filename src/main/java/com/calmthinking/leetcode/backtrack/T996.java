package com.calmthinking.leetcode.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 正方形数组的数目
 * @Author: Ybl
 * @Date: 2022/12/15 9:01
 */
public class T996 {

    /**
     * 直接进行全排列，对不符合条件的进行剪枝即可
     */


    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, list, used, nums, 0);
        return result.size();
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, boolean[] used, int[] nums, int num) {
        if (num == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (list.size() == 0) {
                list.add(nums[i]);
            } else {
                int sum = list.get(list.size() - 1) + nums[i];
                int sqrt = (int) Math.sqrt(sum);
                if (sqrt * sqrt == sum) {
                    list.add(nums[i]);
                } else {
                    continue;
                }
            }
            used[i] = true;
            System.out.println("当前数据组:"+ JSON.toJSONString(list));
            backtrack(result, list, used, nums, num+1);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        T996 t996 = new T996();
        int perms = t996.numSquarefulPerms(new int[]{1, 17, 8});
        System.out.println(perms);

    }

}
