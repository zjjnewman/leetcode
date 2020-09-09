package qiuzhao.novida;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class T1 {



    public static void main(String[] args) {
        int q=100000+1;
        int[] a = new int[q];
        boolean[] tag =new boolean[q];
        int[]p=new int[q];
        int c =0;
        int k=0;
        for (int i = 2; i < q; i++) {
            if(!tag[i]){
                p[c]=i;
                c++;
                for (int j = 2 *i; j < q; j=j+i) {
                    tag[j] = true;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = i + 1; j < c; j++) {
                k = p[i] + p[j];
                if (k < q) {
                    a[k]++;
                } else {
                    break;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(a[n]);
        }
        scanner.close();
    }
}
