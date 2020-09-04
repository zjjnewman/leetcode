package qiuzhao.guanglianda;

import java.util.Scanner;

public class Main {

    /**
     * 共有 c
     *
     * 可以选n种 每种 花费 cj 得到收获wj
     *
     * 在c内找出收益最大化wj
     *
     */
    public int win(int charge, double[] c, int[] w){

        double[] w_c = new double[c.length];

        for (int i = 0; i < c.length; i++) {
            w_c[i] = (double) w[i] / c[i];
        }

        double tmp = 0;
        int idx = -1;
        int cnt = 0;

        for (int j = 0; j < w.length; j++) {
            for (int i = 0; i < c.length; i++) {
                if(tmp < w_c[i]){
                    tmp = w_c[i];
                    idx = i;
                }
            }

            if(charge - c[idx] >= 0){
                w_c[idx] = -1;
                charge = (int) (charge - c[idx]);
                cnt = cnt + w[idx];
            } else {
                break;
            }
            tmp = 0;
        }

        return cnt;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int charge = scanner.nextInt();

        double[] c = new double[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextDouble();
            w[i] = scanner.nextInt();
        }
        Main m = new Main();
        int win = m.win(charge, c, w);
        System.out.println(win);

    }
}
