package zhuanxiang.backtracking;

import java.security.interfaces.ECKey;
import java.util.*;

/**
 * 51. N皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class LC0051 {
    public static List<List<String>> solveNQueens(int n) {
        char[][] set = new char[n][n];
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set[0].length; j++) {
                set[i][j]='.';
            }
        }
        Set<List<String>> ans = new HashSet<>();
        dfs(set, n, ans);
        System.out.println(ans);
        return new ArrayList<>(ans);
    }

    public static void dfs(char[][] set, int cnt, Set<List<String>> ans){
        if(cnt == 0){
            ArrayList<String> combine = new ArrayList<>();
            for (char[] chars : set) {
                String s = String.valueOf(chars);
                combine.add(s);
            }
            ans.add(combine);
            return;
        }
        for(int i = 0; i<set.length; i++){
            for(int j = 0; j<set[0].length; j++){
                if(canSet(set,i,j)){
                    set[i][j] = 'Q';
                    dfs(set, cnt-1, ans);
                    set[i][j] = '.';
                }
            }
        }
    }

    public static boolean canSet(char[][] set, int i, int j){
        if(set[i][j]=='Q'){
            return false;
        }

        // 横向 水平 horizontal
        for(int k=0; k<set[0].length; k++ ){
            if(k!=j && set[i][k] == 'Q'){
                return false;
            }
        }
        // 纵向 垂直 vertical
        for(int k=0; k<set.length; k++ ){
            if(k!=i && set[k][j] == 'Q'){
                return false;
            }
        }

        // 正对角线增大方向
        for(int k= i+1, l=j+1; k<set.length && l<set[0].length; k++,l++){
            if(k >= set.length || l>=set[0].length){
                break;
            }
            if(set[k][l] == 'Q'){
                return false;
            }
        }
        // 正对角线减小方向
        for(int k= i-1, l=j-1; k>=0 && l>=0; k--,l--){
            if(k<0 || l<0){
                break;
            }
            if(set[k][l] == 'Q'){
                return false;
            }
        }
        // 副对角线减小
        for(int k = i+1,l=j-1; k<set.length && l>=0; k++,l--){
            if(k>=set.length || l<0){
                break;
            }
            if(set[k][l] == 'Q'){
                return false;
            }
        }

        // 副对角线增大
        for(int k = i-1,l=j+1; k>=0 && l<set[0].length; k--,l++){
            if(k<0 || l >= set[0].length){
                break;
            }
            if(set[k][l] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
