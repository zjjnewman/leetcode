package qiuzhao.jibite;

import java.util.Scanner;

public class Main2 {
    /**
     * A 产出 xa B  ya C
     * B 产出 xb A  yb C
     * C 产出 xc A  yc B
     */

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int N = scanner.nextInt();

        int xa = scanner.nextInt();
        int ya = scanner.nextInt();

        int xb = scanner.nextInt();
        int yb = scanner.nextInt();

        int xc = scanner.nextInt();
        int yc = scanner.nextInt();

        "".length();
        int aa = y * xb * N + z * xc * N;
        int bb = x * xa * N + z * yc * N;
        int cc = x * ya * N + y * yb * N;
        System.out.println(aa % 1000000007 + " "+bb% 1000000007+ " " + cc% 1000000007);

    }
}
