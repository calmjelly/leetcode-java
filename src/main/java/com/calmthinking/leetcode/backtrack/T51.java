package com.calmthinking.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 51. N 皇后
 * @Author: Ybl
 * @Date: 2023/1/7 16:59
 */
public class T51 {

    public static void main(String[] args) {
        T51 t51 = new T51();
        List<List<String>> lists = t51.solveNQueens(1);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

    /**
     * 21年面小红书的面试题，白板没写出来，一面GG
     * 很典型的回溯题：
     * 1、定义一个二维char数组，用来存放皇后的位置，初始化为'.'
     * 2、定义一个isValid方法，用来判断当前位置是否可以放置皇后
     *      a.判断当前列是否有皇后
     *      b.判断当前行是否有皇后 (这个实际上不需要，因为是逐行填充的，所以当前行必定是没有皇后的)
     *      c.判断当前位置的左上斜线是否有皇后
     *      d.判断当前位置的右上斜线是否有皇后
     *   如果都没有皇后，返回true
     * 3、填充方式为逐行填充，如果该行找到了位置可以防止皇后，则调用递归方法，尝试去填充下一行
     * 4、如果填充到最后一行，说明找到了一个解，将该解加入到结果集中
     * 5、还需要一个将2维数组转为List<String>的方法。。
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(result, board, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(charArraysToList(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(row, i, board)) {
                //开始回溯
                board[row][i] = 'Q';
                backtrack(result, board, row + 1);
                //恢复现场
                board[row][i] = '.';
            }
        }
    }

    /**
     * 校验当前位置是否可以放置皇后
     *
     * @param row
     * @param col
     * @param board
     * @return
     */
    private boolean isValid(int row, int col, char[][] board) {
        //判断当前列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //判断左上斜线(i-1,j-1)
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //判断右上斜线
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将二维数组转为List<String>
     *
     * @param board
     * @return
     */
    private List<String> charArraysToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            list.add(new String(chars));
        }
        return list;
    }


}
