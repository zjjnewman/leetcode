package qiuzhao.pinduoduo;

import java.util.Scanner;

public class T55 {



    private static boolean isTrue(int t, int[] a){
        for (int i = 0; i < a.length; i++) {
            if(t%a[i]==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        int [] a = new int[count];
        boolean isT = false;
        boolean isF = false;
        for (int i = 0; i < count; i++) {
            a[i]=sc.nextInt();
            if (a[i]==1){
                isF=true;
            }
            if(a[i]==2){
                isT = true;
            }
        }
        if(isF){
            System.out.println(n);
            return;
        }
        int sum = 0;
        if(isT){
            sum = sum+n/2;
            for (int i = 1; i <=n; i=i+2) {
                if(isTrue(i,a))
                    sum = sum+1;
            }
            System.out.println(sum);
        }else {
            for (int i = 1; i <=n ; i++) {
                if(isTrue(i, a))
                    sum = sum+1;
            }
            System.out.println(sum);
        }
    }



}
