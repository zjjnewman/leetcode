package qiuzhao.weizhongyinhang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        /**
         * 第一行两个整数n, q分别表示数组的长度和查询的次数。(1≤n，q≤1e5)
         *
         * 第二行n个数分别表示a1, a2, a3, … an。(0≤ai≤1e8)
         *
         * 接下来q行每行一个数x表示需要查询的数。(0≤x≤1e8)
         */
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr=new int[n];
        LinkedList<Integer> deq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {

            int ask = sc.nextInt();

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                min = Math.min(min, Math.abs(ask - arr[j]));
            }

            int retMin = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if(Math.abs(ask - arr[j]) == min){
                    retMin = Math.min(retMin, arr[j]);
                }
            }
            System.out.println(retMin);
        }

    }
}
