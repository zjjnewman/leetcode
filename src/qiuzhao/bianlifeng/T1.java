package qiuzhao.bianlifeng;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T1 {

    public static String removeOneConnection(int[][] edges){
        return null;
    }

    public static boolean isHL(int[][] graph,int n){
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edg : graph) {
            int n1=edg[0];
            int n2=edg[1];
            if(adj[n1]==null){
                adj[n1] = new ArrayList<>();
            }
            if(adj[n2]==null){
                adj[n2] = new ArrayList<>();
            }
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        boolean[] visited = new boolean[n];
        int[] a ={0};
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfsCycle(adj, i, -1,visited, a);
                if(a[0]==1){
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfsCycle(List<Integer>[] adj, int cur, int parent, boolean[] visited, int[] flag) {
        visited[cur]=true;
        List<Integer> list = adj[cur];
        for (Integer integer : list) {
            if(!visited[integer]){
                dfsCycle(adj,integer,cur,visited,flag);
            }else if(integer!=parent){
                flag[0]=1;
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll(" ", "");
        str = str.replaceAll("\\[","");
        str = str.replaceAll("\\]","");
        String[] nodes = str.split(",");
        int[] nums = new int[nodes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(nodes[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int[][] edges = new int[max][max];
        for (int i = 0; i < nums.length - 1; i+=2) {
            edges[nums[i]-1][nums[i+1]-1] = 1;
            edges[nums[i+1]-1][nums[i]-1] = 1;
        }

        int[][] graph = new int[nodes.length/2][2];

        for (int i = 0; i < nums.length-1; i+=2) {
            graph[(i+1)/2][0] = nums[i]-1;
            graph[(i+1)/2][1] = nums[i+1]-1;
        }
        System.out.println(Arrays.deepToString(graph));
        if(isHL(graph, max)){
            System.out.println("Y");
        }else {
            System.out.println("N");
        }
    }
}
