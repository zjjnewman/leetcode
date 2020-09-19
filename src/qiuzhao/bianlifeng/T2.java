package qiuzhao.bianlifeng;

import java.util.*;

public class T2 {


    public static boolean can(int num, List<List<Integer>>  adjacency){
        int[] indegrees = new int[num];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if(indegrees[i]==0)queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            num--;
            for (Integer cur : adjacency.get(pre)) {
                if(--indegrees[cur]==0)queue.add(cur);
            }
        }
        return num==0;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>>  adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             String s = sc.nextLine();
             s = s.replaceAll(" ","");
             s = s.replaceAll("->","");
             char[] cs = s.toCharArray();
             adjacency.add(new ArrayList<>());
             adjacency.get(i).add(cs[0]-'A');
             adjacency.get(i).add(cs[1]-'A');
        }
        int max = 0;
        for (List<Integer> list : adjacency) {
            for (Integer integer : list) {
                max = Math.max(integer, max);
            }
        }
        int num = max+1;

        if(can(num,adjacency)){
            System.out.println("Y");
        }else {
            System.out.println("N");
        }

    }
}
