package qiuzhao.sougou;

import java.util.Scanner;

public class T3 {

    public int getHouses1 (int t, int[] xa) {
        if(xa.length == 0)return 1;
        if(xa.length==1) return 2;
        int res = 2;
        for (int i = 2; i < xa.length; i+=2) {
            double a = xa[i-2]+xa[i-1]/2.0;
            double b = xa[i] - xa[i+1]/2.0;
            if(b-a == t){
                res++;
            }else if(b-a >= t){
                res = res+2;
            }
        }
        return res;
    }


    public int getHouses (int t, int[] xa) {
        // write code here

        int len = xa.length;
        if(len == 0){
            return 1;
        }
        if(len == 1){
            return 2;
        }
        int r = 2;
        for (int i = 2; i < len; i = i + 2) {
            double a = xa[i - 2] + xa[i - 1] / 2.0;
            double b = xa[i] - xa[i + 1] / 2.0;
            if((a - b) == t){
                r++;
            }else{
                r+=2;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println(48);
    }
}
