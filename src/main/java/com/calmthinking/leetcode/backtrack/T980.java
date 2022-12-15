package com.calmthinking.leetcode.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 980、不同路径III
 * @Author: Ybl
 * @Date: 2022/12/15 8:55
 */
public class T980 {
    /**
     * 思路：
     * 1、遍历二维数组，找到起始位置和结束位置，并统计无障碍坐标的数量。
     * 2、从起始位置出发，进行深度优先搜索，标记到过的位置到used数组里面
     * 3、上下左右{(-1,0),(1,0),(0,-1),(0,1)} 四个方向尝试
     * 4、无障碍坐标数量递减为0，并且到达了结束位置时，存储此次遍历的结果集
     */

    private int[][] nextArr = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    List<List<int[]>> result;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    continue;
                }
                if (grid[i][j] == 0) {
                    total++;
                }
            }
        }
        result = new ArrayList<>();
        boolean[][] used = new boolean[grid.length][grid[0].length];
        used[startX][startY] = true;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{startX, startY});
        backtrack(list, startX, startY, total, grid, used);
        return result.size();
    }

    private void backtrack(List<int[]> list, int startX, int startY, int total, int[][] grid, boolean[][] used) {
        if (grid[startX][startY] == 2) {
            if (total == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int[] next : nextArr) {
            int nextX = startX + next[0];
            int nextY = startY + next[1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                if (used[nextX][nextY]) {
                    continue;
                }
                if (grid[nextX][nextY] == -1) {
                    continue;
                }
                if (grid[nextX][nextY] == 0) {
                    total--;
                }
                used[nextX][nextY] = true;
                list.add(new int[]{nextX, nextY});
                System.out.println("当前的数据:" + JSON.toJSONString(list));
                backtrack(list, nextX, nextY, total, grid, used);
                if (grid[nextX][nextY] == 0) {
                    total++;
                }
                list.remove(list.size() - 1);
                used[nextX][nextY] = false;
            }
        }
    }

    public static void main(String[] args) {
        T980 t980 = new T980();
        int pathsIII = t980.uniquePathsIII(new int[][]{{1, 0, 0}, {-1, 0, 0}, {-1, 0, 2}});
        System.out.println(pathsIII);
    }

}
