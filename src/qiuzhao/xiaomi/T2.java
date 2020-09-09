package qiuzhao.xiaomi;

import java.util.Scanner;

public class T2 {

    public static char[][] matchs = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };

    public static String isExist(char[] chars){
        for (int i = 0; i < matchs.length; i++) {
            for (int j = 0; j < matchs[0].length; j++) {
                if(matchs[i][j] == chars[0]){
                    if(dfs(matchs, chars, i,j,0)){
                        return "true";
                    }
                }
            }
        }
        return "false";
    }



    public static boolean dfs(char[][] board, char[] word, int index, int i, int j){
        if(index == word.length){
            return true;
        }
        if(i<0||i>= board.length||j<0||j>= board[0].length||board[i][j]!= word[index]){
            return false;
        }
        board[i][j] = '*';
        boolean res = dfs(board,word,i+1,j,index+1) ||
                dfs(board,word,i-1,j,index+1) ||
                dfs(board,word,i,j+1,index+1) ||
                dfs(board,word,i,j-1,index+1);
        board[i][j]= word[index];
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(isExist(next.toCharArray()));

    }
}
