package qiuzhao.pinduoduo;

import java.util.Scanner;

public class T11 {

    public static int[][] method(int n){
        int[][] a = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                float tmp = (n+1);
                tmp = tmp/2;
                if(i==j||i+j==n+1||i==tmp||j==tmp) a[i][j]=0;
                if(i+j<(n+1)&& j>tmp) a[i][j]=1;
                if(i<j && j<tmp) a[i][j]=2;
                if(i>j&& i<tmp) a[i][j] =3;
                if(i+j<(n+1)&& i>tmp) a[i][j]=4;
                if(i+j>(n+1)&& j<tmp) a[i][j]=5;
                if(i>j&& j>tmp) a[i][j]=6;
                if(i<j && i>tmp) a[i][j]=7;
                if(i+j>n+1 && i<tmp)  a[i][j]=8;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = method(n);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] +" ");
            }
            System.out.println("");
        }
    }
}
