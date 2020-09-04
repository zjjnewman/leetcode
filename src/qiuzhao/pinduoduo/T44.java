package qiuzhao.pinduoduo;

import java.util.Scanner;

public class T44 {

    public static int method1(int n, int[] ms){

        int cnt = 0;
        boolean[] b = new boolean[n+1];
        for (int i = 0; i < ms.length; i++) {
            int base = ms[i];
            for (int j = 1; j * ms[i] <= n; j++) {
                b[j * ms[i]] = true;
            }
        }
        for (int i = 1; i < b.length; i++) {
            if(b[i]){
                cnt++;
            }
        }
        return cnt;
    }


    public static int method(int n, int[] ms){
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < ms.length; j++) {
                if(i % ms[j] == 0){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 正整数x可以被 特征值集合中的某个数 Y整除————》x具有显著特征

        // 正整数集合 1-n
        int n = scanner.nextInt();
        // m个特征值组成的集合 ---》 特征值集合
        int m = scanner.nextInt();

        // 求 集合 1-n 中有多少 显著特征数字

        // 特征值集合
        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = scanner.nextInt();
        }
        if(m == 0){
            System.out.println(0);
        } else {
            System.out.println(method1(n, ms));
        }
    }
}
