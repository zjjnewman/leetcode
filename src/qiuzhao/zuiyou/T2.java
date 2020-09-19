package qiuzhao.zuiyou;

import java.util.*;

public class T2 {

    public static int[] getTriggerTime (int[][] increase, int[][] requirements) {

        if(requirements.length == 0){
            return new int[0];
        }

        int[] crh = new int[3];
        int[] starts = new int[requirements.length];
        Arrays.fill(starts, -1);
        int cnt = 0;

        boolean[] visited = new boolean[requirements.length];

        for (int i = 0; i < requirements.length; i++) {
            if(!visited[i] && crh[0] >= requirements[i][0] && crh[1] >= requirements[i][1] && crh[2] >= requirements[i][2]){
                visited[i] = true;
                starts[i] = cnt;
            }
        }

        for (int[] ints : increase) {
            crh[0] += ints[0];
            crh[1] += ints[1];
            crh[2] += ints[2];
            cnt++;

            for (int i = 0; i < requirements.length; i++) {
                if(!visited[i] && crh[0] >= requirements[i][0] && crh[1] >= requirements[i][1] && crh[2] >= requirements[i][2]){
                    visited[i] = true;
                    starts[i] = cnt;
                }
            }

        }
        return starts;
    }

    public static void main(String[] args) {

        int[][] a = new int[][]{{2,8,4},{2,5,0},{10,9,8}};
        int[][] b = new int[][]{{2,11,3},{15,10,7},{9,17,12},{8,1,14}};

        int[][] c = new int[][]{{0,4,5},{4,8,8},{8,6,1},{10,10,0}};
        int[][] d = new int[][]{{12,11,16},{20,2,6},{9,2,6},{10,18,3},{8,14,9}};

        int[][] e = new int[][]{{1,1,1}};
        int[][] f =new int[][]{{0,0,0}};

        int[] triggerTime = getTriggerTime(e, f);
        for (int i : triggerTime) {
            System.out.print(i+" ");
        }
    }
}
