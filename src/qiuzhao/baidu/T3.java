package qiuzhao.baidu;

import java.util.Scanner;

public class T3 {

    static int mod = 1000000007;
    public static int jump(int m, int n){
        if(n < m + 1){
            return n;
        }

        int a =1;
        int b = m;
        int sum = 0;
        for (int i = m+1; i <= n; i++) {
            sum = a+b % mod;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int jump1(int m, int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n ==0){
            System.out.println(0);
        }else if( n == 1){
            System.out.println(1);
        }else {

            System.out.println(jump(m, n));
        }

    }
}
