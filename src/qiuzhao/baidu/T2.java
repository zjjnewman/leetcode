package qiuzhao.baidu;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 待测数据量
        int t = scanner.nextInt();
        // 奶牛数量
        int n = scanner.nextInt();
        // 需要满足的特征数量
        int m = scanner.nextInt();

        ArrayList<int[]> qjs = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            // 这个特征在奶牛中满足的 区间数量
            int k = scanner.nextInt();
            int[] qu = new int[k*2];
            for (int i = 0; i < k*2 -1; i = i+2) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                qu[i] = l;
                qu[i+1] = r;
            }
            qjs.add(qu);
        }

        // 每个奶牛特征
        int[] z = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < qjs.size(); j++) {
                int[] ints = qjs.get(j);
                for (int k = 0; k < ints.length - 1; k = k + 2) {
                    int l = ints[k];
                    int r = ints[k+1];
                    if(i >= l && i<= r){
                        z[i]++;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(z[i] >= m){
                cnt++;
            }
        }
        System.out.println(cnt);
        for (int i = 1; i <= n; i++) {
            if(z[i] >= m){
                System.out.print(i+" ");
            }
        }
    }
}
