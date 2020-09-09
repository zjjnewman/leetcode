package zhuanxiang.backtracking;

public class LC0079 {
    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chars, i, j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int idx) {
        if(idx == chars.length){
            return true;
        }

        if(i <0 || j<0 || j >= board[0].length || i >= board.length){
            return false;
        }

        if(board[i][j] != chars[idx]){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean ret = dfs(board,chars,i+1,j,idx+1) ||
                dfs(board,chars,i-1,j,idx+1) ||
                dfs(board,chars,i,j+1,idx+1) ||
                dfs(board,chars,i,j-1,idx+1);
        board[i][j] = c;
        return ret;
    }
}
