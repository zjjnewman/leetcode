package qiuzhao.jinshanyun;

import java.util.Scanner;

public class T1 {

    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int a1 = 0;
        int a2 = 1;
        int a3 = -1;
        int i = n;
        while (i >= 2){
            a3 = (a1 + a2);
            a1 = a2;
            a2 = a3;
            i--;
        }
        return a3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j = 1; j <= n; j++) {
            int[] nums = new int[j-1];
            for (int i = 1; i <= j; i++) {
                int a = fib(i);
                if(i-1 < j-1){
                    nums[i-1] = a;
                }
                System.out.print(a+" ");
            }
            for (int i = j - 2; i >= 0 ; i--) {
                System.out.print(nums[i]+" ");
            }
            System.out.println("");
        }
    }
}
