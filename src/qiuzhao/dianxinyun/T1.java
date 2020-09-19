package qiuzhao.dianxinyun;

import java.util.Scanner;

public class T1 {

    public static int[] cNumber(int n){
        if(n <= 0){
            return null;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int a=0, b=0, c=0;
        for (int i = 1; i < n; i++) {
            int k = dp[a]*2 < dp[b]*3 ? dp[a]*2 : dp[b]*3;
            dp[i] = k < dp[c]*5 ? k : dp[c]*5;
            if(dp[a]*2==dp[i]) a++;
            if(dp[b]*3==dp[i]) b++;
            if(dp[c]*5==dp[i]) c++;
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = cNumber(n);
        System.out.println(dp[n-1]);
    }
}
