package qiuzhao.pinduoduo;

import java.util.Scanner;

public class T33 {
    public static int maxVal(int capacity, int[] weight, int[] value){
        // 代表物品个数
        int iNum = value.length + 1;
        // 代表背包容量
        int wSize = capacity + 1;
        int[][] dp = new int[iNum][wSize];

        //初始化
        // 当 物品只有 1个，容量w增大时最大价值为 第一个物品的价值
        for (int i = 1; i < wSize; i++) {
            // 当背包容量大于等于 物品重量
            if(i >= weight[0]){
                dp[1][i] = value[0];
            }
        }
        //初始化
        // 当 背包容量只有1，物品i增大时
        for (int i = 1; i < iNum; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1]);
        }

        // 有了初值之后，根据初值计算
        for (int i = 1; i < iNum; i++) {
            for (int j = 1; j < wSize; j++) {
                if(j >= weight[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + value[i - 1]);
                } else{
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[iNum - 1][wSize- 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 商品总数
        int n = scanner.nextInt();
        // 背包原始大小
        int m = scanner.nextInt();
        // 商品占用空间
        int[] c = new int[n];
        // 商品收益
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        System.out.println(maxVal(m, c, v));
    }
}
