package test;

import java.util.Scanner;

public class T4 {
    static int count = 1;
    public static int total(int year, int a1, int a2, int a3){

        for (int i = 0; i <= year; i++) {
            if(i==a1||i==a2){
                count++;
                total(year-i, a1,a2,a3);
            }
            if(i==a3){
                count--;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int year = sc.nextInt();
        System.out.println(total(year, a1, a2, a3));
    }
}
