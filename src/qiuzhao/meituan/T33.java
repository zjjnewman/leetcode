package qiuzhao.meituan;


import java.util.Scanner;

public class T33 {

    private static int getBi(int[] ai, int i){

        int n = ai.length - 1;
        int ret = ai[i];
        for (int j = 1; j <= n ; j++) {
            ret = ret ^ (i % j);
        }
        return ret;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 序列a的长度为n
        int n = scanner.nextInt();
        int[] ai = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ai[i] = scanner.nextInt();
        }

        int ret = getBi(ai, 1);
        for (int i = 2; i <= n; i++) {
            ret = ret^getBi(ai,i);
        }
        System.out.println(ret);
    }
}
