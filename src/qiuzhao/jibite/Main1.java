package qiuzhao.jibite;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String c1 = scanner.next();
        String c2 = scanner.next();

        str = str.toLowerCase();
        c1 = c1.toLowerCase();
        c2 = c2.toLowerCase();
        char ca = c1.charAt(0);
        char cb = c2.charAt(0);

        int i = 0;
        int j = str.length() - 1;
        int k = 0;
        int p = str.length() - 1;

        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        boolean aF = true;
        boolean bF = true;
        while (i <= j){
            if(aF && str.charAt(i) == ca){
                a1 = i;
                aF = false;
            } else {
                i++;
            }
            if(bF && str.charAt(j) == cb){
                b1 = j;
                bF = false;
            } else {
                j --;
            }
        }
        while (k <= p){
            if(aF && str.charAt(i) == cb){
                a2 = i;
                aF = false;
            } else {
                k++;
            }
            if(bF && str.charAt(j) == ca){
                b2 = j;
                bF = false;
            } else {
                p --;
            }
        }



        if(b2 - a2 > b1 - a1){
            System.out.println(b2 - a2);
        } else if(b2 - a2 <= b1 - a1){
            System.out.println(b1 - a1);
        }
    }
}
