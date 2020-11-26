package qiuzhao.yuewen;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().replaceAll(" ", "").split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0 ; j--){
                System.out.print(matrix[j][i]);
                if(i == n-1 && j== 0){

                }else {
                    System.out.print(",");
                }
            }
        }

    }
}
/*
4
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16
 */