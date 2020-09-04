package zhuanxiang.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 51. N皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class LC0051 {
    public List<List<String>> solveNQueens(int n) {
        "".length();
        return null;
    }

    public boolean isMatch(String s, String p) {
        //dp[i][j] 是前i个字符串是否与前j个模式串匹配
        int sL = s.length() + 1;
        int pL = p.length() + 1;
        boolean[][] dp = new boolean[sL][pL];
        char[] charsP = p.toCharArray();
        char[] charsS = s.toCharArray();
        //初始状态
        // [i][0] false
        // [0][i] 分情况
        dp[0][0] = true;
        for(int i=1; i<pL-1;i++){
            if(charsP[i-1] == '*'){
                dp[0][i]=true;
            }else{
                break;
            }
        }

        for(int i = 1;i < sL;i++){
            for(int j=1; i < pL; j++){
                if(charsP[j-1]!='*'){
                    dp[i][j] = (charsP[j-1]=='?' || charsS[i-1]==charsP[j-1])&& dp[i-1][j-1];
                } else{

                }
            }
        }
        return dp[sL-1][pL-1];
    }

    public boolean helper(int n, boolean[][] canDo){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    canDo[j][k] = true;
                }
            }

        }

        ArrayList<Integer> list;
        return true;
    }
}
