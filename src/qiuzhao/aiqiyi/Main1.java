package qiuzhao.aiqiyi;

import java.util.Scanner;

public class Main1 {

    // n的阶乘
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(trailingZeroes(n));
    }
}
