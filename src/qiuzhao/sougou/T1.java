package qiuzhao.sougou;

import java.util.Scanner;

public class T1 {

    public static int method(int a, int b, int c){
        long sum = a + b + c;
        // 平均值
        long av = sum/3;
        for (long i = av; i >= 0; i--) {
            long left = sum - 3 * i;
            long right = 0;
            if(i - a > 0) right = right + i - a;
            if(i - b > 0) right = right + i - b;
            if(i - c > 0) right = right + i - c;
            if(left >= right) return (int)i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 使用3个道具各1个换取 1个奖品，
        // 可以用任意2件道具 换另外1种指定的道具，求最多换取的奖品数
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(method(a, b, c));
    }
}
