package com.calmthinking.leetcode.weekly_contest.wk_327;

import java.util.PriorityQueue;
/**
 * @Description: 6285. 执行 K 次操作后的最大分数
 * @Author: Ybl
 * @Date: 2023/1/8 12:30
 */
public class T6258 {
    public static void main(String[] args) {
        T6258 t = new T6258();
        int[] nums = {822539285, 410243778, 843804474, 77808436, 604773488, 91882183, 983148575, 707291538, 210570310, 256880418, 744202637, 272026597, 850035362, 815964585, 161539308, 807997984, 975169847, 373595653, 740848840, 596578711, 634140518, 805359728, 893113934, 983095872, 740000028, 424404126, 645488102, 398147052, 399134531, 455173503, 762937622, 135977920, 886567539, 210644714, 441883025, 440353920, 151652262, 540667241, 41680120, 612170826, 757875616, 630417303, 829178537, 765944292, 440167660, 811916049, 764614502, 101017579, 296944070, 726251399};
        System.out.println(t.maxKelements(nums, 53));
    }

    /**
     * 直接用全部元素构建一个大顶堆，每次弹出堆顶元素，累加后除以3，然后再放回堆中，重复K次即可
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        //构建大顶堆，
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
        }
        long sum = 0;
        while (k > 0) {
            //堆顶元素出队，累加
            Integer changeVal = maxHeap.poll();
            //累加
            sum += changeVal;
            //元素减小为1/3，然后重新入队
            changeVal = (int) Math.ceil(changeVal / 3.0);
            maxHeap.add(changeVal);
            --k;
        }
        return sum;
    }
}
