package qiuzhao.jingdong;

import java.util.Scanner;

public class T2 {

    public static boolean dfs(char[][] graph, int i, int j, int k, int l){
        if(i >= graph.length || i < 0 || j >= graph[0].length || j < 0){
            return false;
        } else if (graph[i][j] =='#'){
            return false;
        } else if(graph[i][j] == 'E'){
            return true;
        }
        return dfs(graph, i+1,j,k,l) ||
                dfs(graph, i-1,j,k,l) ||
                dfs(graph, i,j+1,k,l) ||
                dfs(graph, i,j-1,k,l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());

        //接下来n行表示地图，每一行都有m个字符，其中S表示王子的位置，E表示公主的位置，'.'表示可以通行，'#'表示障碍物（不能通行）
        for (int f = 0; f < t; f++) {
            String nm = sc.nextLine();
            String[] nms = nm.split(" ");
            int n = Integer.parseInt(nms[0]);
            int m = Integer.parseInt(nms[1]);
            char[][] graph = new char[n][m];
            // 公主位置横纵坐标
            int k = 0, l = 0;
            int v = 0, w = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                s = s.replaceAll(" ","");
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    if(c == 'E'){
                        k = i;
                        l = j;
                    }
                    if(c == 'S'){
                        v = i;
                        w = j;
                    }
                    graph[i][j] = c;
                }
            }
            if(dfs(graph, v,w, k,l)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }


}
