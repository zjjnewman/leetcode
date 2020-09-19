package qiuzhao.bianlifeng;

import java.util.Scanner;

public class T3 {

    public static int buy(int money, int[] items){
        int[] dp = new int[money+1];
        dp[0] = 1;
        for (int i = 0; i < items.length; i++) {
            for (int j = 1; j <=money; j++) {
                if(j >= items[i]){
                    dp[j] += dp[j- items[i]];
                }
            }
        }
        return dp[money];
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int money = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        s = s.replaceAll(" ", "");
        String[] strs = s.split(",");
        int[] items = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            items[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(buy(money, items));
    }
}
