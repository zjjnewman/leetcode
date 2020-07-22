package leetcode.graph;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import sun.jvm.hotspot.HelloWorld;
import sun.security.action.PutAllAction;

import javax.swing.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.ResultSet;

/**
 * 剑指 Offer 12. 矩阵中的路径 https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class JZ11 {

    public boolean exist(char[][] board, String word) {

        int[][] isAccessed = new int[board.length][board[0].length];
        char[] targets = word.toCharArray();

        boolean result = false;

        for (int i = 0; i < board.length; i++) {// row
            for (int j = 0; j < board[0].length; j++) {// column
                if (board[i][j] == targets[0]){
                    isAccessed[i][j] = 1;
                    result = helper(board, isAccessed, i, j, targets, 1);
                }
                if (result){
                    return true;
                } else {
                    for (int k = 0; k < isAccessed.length; k++) {
                        for (int l = 0; l < isAccessed[0].length; l++) {
                            isAccessed[k][l] = 0;
                        }
                    }
                }
            }
        }

        return false;
    }


    // row column 是当前要匹配字符的位置，idx记录当前要处理的字符的位置
    public boolean helper(char[][] board, int[][] isAccessed, int row, int column, char[] targets, int idx){

        if(board[row][column] != targets[idx]){
            return false;
        } else {
            isAccessed[row][column] = 1;
        }

        boolean result = false;
        /**
         * 已匹配第一个字母，当前字母的基础上匹配下一个字母，遍历每个方向，直到匹配到，如果都没匹配到，返回false
         */
        //探寻下 row + 1 column
        if(row + 1 < board.length && isAccessed[row + 1][column] == 0 && board[row + 1][column] == targets[idx + 1]){
            isAccessed[row + 1][column] = 1;
            result = helper(board, isAccessed, row + 1, column, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row + 1][column] = 0;
            }
        }


        if(row - 1 >= 0 && isAccessed[row - 1][column] == 0 && board[row - 1][column] == targets[idx + 1]){// 探寻上 row - 1 column
            isAccessed[row - 1][column] = 1;
            result = helper(board, isAccessed, row - 1, column, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row - 1][column] = 0;
            }
        }


        if(column - 1 >= 0 && isAccessed[row][column - 1] == 0 && board[row][column - 1] == targets[idx + 1]) {// 探寻左 row column - 1
            isAccessed[row][column - 1] = 1;
            result = helper(board, isAccessed, row, column - 1, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row][column - 1] = 0;
            }
        }


        if(column + 1 < board[0].length && isAccessed[row][column + 1] == 0 && board[row][column + 1] == targets[idx + 1]) {// 探寻右 row column - 1
            isAccessed[row][column + 1] = 1;
            result = helper(board, isAccessed, row, column + 1, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row][column + 1] = 0;
            }
        }

        return false;
    }


    // row column 是上一个已经匹配字符的位置，idx记录当前要处理的字符的位置
    public boolean helper2(char[][] board, int[][] isAccessed, int row, int column, char[] targets, int idx){

        if (idx == targets.length){
            return true;
        }

        boolean result = false;
        /**
         * 已匹配第一个字母，当前字母的基础上匹配下一个字母，遍历每个方向，直到匹配到，如果都没匹配到，返回false
         */
        //探寻下 row + 1 column
        if(row + 1 < board.length && isAccessed[row + 1][column] == 0 && board[row + 1][column] == targets[idx]){
            isAccessed[row + 1][column] = 1;
            result = helper(board, isAccessed, row + 1, column, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row + 1][column] = 0;
            }
        }



        if(row - 1 >= 0 && isAccessed[row - 1][column] == 0 && board[row - 1][column] == targets[idx]){// 探寻上 row - 1 column
            isAccessed[row - 1][column] = 1;
            result = helper(board, isAccessed, row - 1, column, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row - 1][column] = 0;
            }
        }


        if(column - 1 >= 0 && isAccessed[row][column - 1] == 0 && board[row][column - 1] == targets[idx]) {// 探寻左 row column - 1
            isAccessed[row][column - 1] = 1;
            result = helper(board, isAccessed, row, column - 1, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row][column - 1] = 0;
            }
        }


        if(column + 1 < board[0].length && isAccessed[row][column + 1] == 0 && board[row][column + 1] == targets[idx]) {// 探寻右 row column - 1
            isAccessed[row][column + 1] = 1;
            result = helper(board, isAccessed, row, column + 1, targets, idx + 1);
            if(result){
                return true;
            } else {
                isAccessed[row][column + 1] = 0;
            }
        }

        return false;
    }


    // idx记录匹配字符的位置
    public boolean helper1(char[][] board, int[][] isAccessed, int row, int column, char[] targets, int idx){

        if (idx == targets.length){
            return true;
        }

        /**
         * 已匹配第一个字母，当前字母的基础上匹配下一个字母，遍历每个方向，直到匹配到，如果都没匹配到，返回false
         */
        //探寻下 row + 1 column
        if(row + 1 < board.length && isAccessed[row + 1][column] == 0 && board[row + 1][column] == targets[idx]){
            isAccessed[row + 1][column] = 1;
            return helper(board, isAccessed, row + 1, column, targets, idx + 1);
        } else if(row - 1 >= 0 && isAccessed[row - 1][column] == 0 && board[row - 1][column] == targets[idx]){// 探寻上 row - 1 column
            isAccessed[row - 1][column] = 1;
            return helper(board, isAccessed, row - 1, column, targets, idx + 1);
        } else if(column - 1 >= 0 && isAccessed[row][column - 1] == 0 && board[row][column - 1] == targets[idx]) {// 探寻左 row column - 1
            isAccessed[row][column - 1] = 1;
            return helper(board, isAccessed, row, column - 1, targets, idx + 1);
        } else if(column + 1 < board[0].length && isAccessed[row][column + 1] == 0 && board[row][column + 1] == targets[idx]) {// 探寻右 row column - 1
            isAccessed[row][column + 1] = 1;
            return helper(board, isAccessed, row, column + 1, targets, idx + 1);
        } else {
            return false;
        }
    }




    public boolean exist1(char[][] board, String word) {
        /**
         * 定位首字母，根据首字母：
         * 1.按单词字母顺序定位下一个字母所在的格子
         * 2.通过这个字母上下左右探寻，找到第二个字母，
         * 3.重复1、2步，直到单词查找完毕，说明存在，
         *
         * 4.若以上三步最终没找到符合要求的下一个字母，重新定位首字母
         */

        if(word == null || word.equals("")){
            return false;
        }

        if(board.length == 0){
            return false;
        }

        // 记录格子是否访问的矩阵
        int[][] isAccess = new int[board.length][board[0].length];
        char[] cws = word.toCharArray();

        // 定位首字母
        for (int i = 0; i < board.length; i++) {// row
            for (int j = 0; j < board[0].length; j++) {// column
                int idx = 0;


            }
        }

        return false;
    }




    /**
     * 根据当前字母的位置，找到下一个字母的位置，若不存在返回 -1
     * @param board
     * @param isAccess 访问标志位矩阵
     * @param row 行标
     * @param column 列标
     * @param target 下一个字母值
     * @return 返回row column 数组，若不存在返回 {-1, -1}
     */
    public int[] findNext(char[][] board, int[][] isAccess, int row, int column, char target){
        //探寻上 row + 1 column
        if(isAccess[row + 1][column] != 1){// if not accessed
            if(board[row + 1][column] == target){
                return new int[]{row + 1, column};
            }
        }
        //探寻上 row + 1 column
        if(isAccess[row - 1][column] != 1){// if not accessed
            if(board[row - 1][column] == target){
                return new int[]{row - 1, column};
            }
        }

        //探寻左 row column - 1
        if(isAccess[row][column - 1] != 1){// if not accessed
            if(board[row][column - 1] == target){
                return new int[]{row, column - 1};
            }
        }

        //探寻右 row column + 1
        if(isAccess[row][column + 1] != 1){// if not accessed
            if(board[row][column + 1] == target){
                return new int[]{row, column + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public int[] up(int row, int column){

        return null;
    }
}



class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int row, int column, int idx) {

        // 越界，或不等于目标char 或已经访问过，返回false
        if(row >= board.length || row < 0 || column >= board[0].length || column < 0 || board[row][column] != word[idx]){
            return false;
        }

        // 顺利匹配到了最后的字符，返回true
        if(idx == word.length - 1){
            return true;
        }


        char tmp = board[row][column];

        // 在board中把当前匹配的字符，置为非字母字符，记录这个字符已经访问。
        board[row][column] = '/';

        //在当前位置 下 上 右 左探寻，如果找到一个匹配的字符，就返回下一步的探寻，直到到了true 或false的条件
        boolean res = dfs(board, word, row + 1, column, idx + 1) || dfs(board, word, row - 1, column, idx + 1) ||
                dfs(board, word, row, column + 1, idx + 1) || dfs(board, word, row , column - 1, idx + 1);

        // 最终程勋走到这里，由非字母字符，还原为原本的字符，然后一路return还原到
        board[row][column] = tmp;

        return res;
    }

}