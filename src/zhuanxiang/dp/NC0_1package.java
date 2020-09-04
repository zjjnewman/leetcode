package zhuanxiang.dp;

import java.util.Scanner;

public class NC0_1package {
    /**
     * 背包问题 https://www.nowcoder.com/questionTerminal/7e157ce9a8c249daa3ddafad322dbf1e
     *
     * 图解 https://blog.csdn.net/qq_37767455/article/details/99086678
     *
     *
     */
    public int maxVal(int capacity, int[] weight, int[] value){
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


    public int maxVal1(int m, int[] w, int[] v){
        // 代表物品个数
        int iNum = v.length + 1;
        // 代表背包容量
        int wSize = m + 1;

        int [][] temp = new int[iNum][wSize];   //8表示背包最多能放8公斤的重量

        for(int i=1;i<iNum;i++) {  //从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大的值
            for(int j=1;j<wSize;j++) { //当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大的值
                if(w[i]<=j) { //重量比这个状态小，那么就能放。 那么就只是放与不放，看是放重量大，还是不放重量大
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i]]+v[i]);
                }else {
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }

        return temp[iNum - 1][wSize - 1];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() + 1;
        int m = scanner.nextInt() + 1;
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 1; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        NC0_1package t = new NC0_1package();
        int ret = t.maxVal(m, w, v);
        System.out.println(ret);

    }
}
