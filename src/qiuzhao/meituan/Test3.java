package qiuzhao.meituan;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //多少组
        int t = scanner.nextInt();

        //员工组
        int[] a = new int[t];
        int[] income = new int[t];


        for (int i = 0; i < income.length; i++) {
            income[i]++;
        }
        int[] e = null;
        boolean isF = true;
        for (int i = 0; i < t; i++) {
            // n名员工
            int n = scanner.nextInt();
            if(isF){
                e = new int[n];
            }
            for (int j = 0; j < n; j++) {
                // 员工所在组
                int g = scanner.nextInt();
                a[g]++;
                e[j] = g;
            }
            isF = false;
        }
        for (int i = 0; i < t; i++) {
            if(e[i] == i){
                income[i]++;
            }
        }

        for (int i : income) {
            System.out.println(i);
        }
    }
}
