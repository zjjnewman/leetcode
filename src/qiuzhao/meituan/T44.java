package qiuzhao.meituan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class T44 {

    private static String isTrue(int n, int[] arr){
        if(n==0){
            return "NO";
        }
        int leaf = 0;
        int father = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                leaf++;
            }else if(arr[i] == 2){
                return "NO";
            }else if(arr[i]>=3){
                father += arr[i]-1;
                leaf++;
            }
        }
        leaf--;
        return father == leaf ? "YES":"NO";
    }

    public  static String helper(int n,int[]arr){
        int leaf=0;
        int noLeaf=0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                leaf++;
            }
            if(arr[i]%2==0){
                return "NO";
            }
            if(arr[i]>=3){
                noLeaf++;
            }
        }

        if(leaf*2-1==n&&arr[arr.length-1]==n){
            if(Math.ceil(leaf-1)==noLeaf){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();

            }
            System.out.println();
            bw.write(helper(n, arr)+"\n");
        }
        bw.flush();
    }
}
