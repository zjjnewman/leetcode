package qiuzhao.wanmeishijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {


    private static int INF=Integer.MAX_VALUE;
    private static int[][] dist;
    private static int[][] path;
    private static List<Integer> result;

    public Main2(int n){
        dist = new int[n][n];
        path = new int[n][n];
        result = new ArrayList<>();
    }

    public static void floydMethod(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dist[i][j] = matrix[i][j];
                path[i][j]=-1;
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(dist[i][k] != INF && dist[k][j]!=INF && dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j]=k;
                    }
                }
            }
        }
    }


    public static void findPath(int i, int j){
        int k = path[i][j];
        if(k==-1)return;
        result.add(k);
        findPath(i,k);
        findPath(k,j);

    }



    private static void method(int[][] weight, String[] pointsStr) {


    }


    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }

}
