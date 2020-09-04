package qiuzhao.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class T1 {

    /**
     * 10^3 内90的倍数所有的集合。
     */
    private static void getValue(){}

    private static int isZeroOrFive(long a){

        int cnt0 = 0;
        int cnt5 = 0;

        while (a > 0){
            long tmp = a % 10;
            System.out.println(tmp);
            if(tmp == 5){
                cnt5++;
            } else if(tmp == 0){
                cnt0++;
            } else {
                return -1;
            }
            a = a / 10;
        }
        return 1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(0,0);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if(t == 5){
                map.put(5,map.get(5)+1);
            } else if(t==0){
                map.put(0, map.get(0)+1);
            }
        }
        System.out.println();

    }
}
