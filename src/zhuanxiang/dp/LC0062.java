package zhuanxiang.dp;

/**
 * 62. 不同路径 https://leetcode-cn.com/problems/unique-paths/submissions/
 */
public class LC0062 {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }

        for(int i  = 1; i < m; i++){
            for(int j  = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int[][] ints = new int[3][2];
        System.out.println(ints.length);
        System.out.println(ints[0].length);
    }
}
