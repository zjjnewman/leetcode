package qiuzhao.weizhongyinhang;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {

        /**
         * 第一行一个整数n，表示序列A的长度。
         * 接下来一行n个整数，第i个数表示Ai的值。
         */
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int cnt = 0;

        //数组个数n
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        if(nums[1]<=nums[2]&& nums[2]<=nums[3]) {
            dp[3] = 1;
        }else {
            dp[3] = 0;
        }



        System.out.println(cnt);
        
    }
}
