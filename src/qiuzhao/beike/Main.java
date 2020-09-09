package qiuzhao.beike;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < n-1; i++) {
            if(arr[i-1]> arr[i] && arr[i+1]>arr[i]){
                if(arr[i-1]<=arr[i+1]){
                    arr[i-1]=arr[i];
                }else {
                    arr[i+1]=arr[i];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
