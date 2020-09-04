package qiuzhao.wanmeishijie;

import java.util.Scanner;

public class Main1 {

    private static int method(int knapsackCapacity, int[] volumes, int[] values) {
        if(knapsackCapacity == 0 || values.length == 0 || volumes.length == 0){
            return 0;
        }

        // 体积
        int[] w = new int[volumes.length + 1];
        // 价值
        int[] v = new int[values.length+1];

        for (int i = 0; i < volumes.length; i++) {
            w[i+1] = volumes[i];
        }

        for (int i = 0; i < values.length; i++) {
            v[i+1] = values[i];
        }

        // 代表物品个数
        int iNum = v.length;
        // 代表背包容量
        int wSize = knapsackCapacity;

        int [][] temp = new int[iNum+1][wSize+1];   //8表示背包最多能放8公斤的重量

        for(int i=1;i<=iNum;i++) {  //从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大的值
            for(int j=1;j<=wSize;j++) { //当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大的值
                if(w[i-1]<=j) { //重量比这个状态小，那么就能放。 那么就只是放与不放，看是放重量大，还是不放重量大
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i-1]]+v[i-1]);
                }else {
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }

        return temp[iNum][wSize];
    }

    private static int method1(int knapsackCapacity, int[] volumes, int[] values) {
        int[] w = volumes;
        int[] v = values;

        // 代表物品个数
        int iNum = v.length;
        // 代表背包容量
        int wSize = knapsackCapacity;

        int [][] temp = new int[iNum+1][wSize+1];   //8表示背包最多能放8公斤的重量

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
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");

        int[] values = new int[valuesStr.length];

        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }


}
