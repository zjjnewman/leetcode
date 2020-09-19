package qiuzhao.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void dfs(int[][] dao, boolean[] visited, int i, int cnt, int k){


        if (cnt == 0){
            return;
        }
        if (!visited[i]){
            visited[i] = true;
            System.out.println(i);
        }
        System.out.println();
        for (int j=0; j< dao.length; j++){
            if(dao[i][j] > 0 && dao[i][j] <=k && !visited[j]){
                dfs(dao, visited, j, cnt-1, k);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<int[][]> group = new ArrayList<>(t);
        int[] capacity = new int[t];
        for (int i = 0; i < t; i++) {
            // n个小岛
            int n = sc.nextInt();
            // m个桥
            int m = sc.nextInt();
            // 造价不能超过k
            int k = sc.nextInt();
            capacity[i] = k;
            int[][] dao = new int[n][n];
            for (int j = 0; j < m; j++) {
                // 横坐标
                int h = sc.nextInt();
                // 纵坐标
                int v = sc.nextInt();
                dao[h-1][v-1] = sc.nextInt();
            }
            group.add(dao);
        }

        for (int i = 0; i < t; i++) {
            int k = capacity[i];
            int[][] a = group.get(i);
            boolean[] visited = new boolean[a.length];
            dfs(a, visited,0,a.length, k);
        }
    }



    /*
2
3 3 400
1 2 200
1 3 300
2 3 500
3 3 400
1 2 500
1 3 600
2 3 700
     */
}
