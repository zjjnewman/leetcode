package qiuzhao.qunawang;

import java.util.*;

public class T2 {

    public static void dfs(String[] ss, int len, int post, List<String> sb, Set<String> ans){
        if(post == ss.length){
            return;
        }
        if(sb.size()==len){
            StringBuilder ssb = new StringBuilder();
            for (String s : sb) {
                ssb.append(s);
            }
            ans.add(ssb.toString());
            return;
        }

        for (int i = post; i < ss.length; i++) {
            for (int j = 1; j <= ss.length; j++) {
                sb.add(ss[i]);
                dfs(ss, len, i+j, sb, ans);
                sb.remove(sb.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] ss1 = sc.nextLine().trim().split(" ");
        String[] ss2 = sc.nextLine().trim().split(" ");

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (int i = 1; i <= ss1.length; i++) {
            dfs(ss1, i, 0,new ArrayList<>(), set1);
        }
        for (int i = 1; i <= ss2.length; i++) {
            dfs(ss2, i, 0,new ArrayList<>(), set2);
        }

        int max =0;
        for (String s : set1) {
            if(set2.contains(s)){
                max = Math.max(max, s.length());
//                System.out.println(s);
            }
        }
        System.out.println(max);
//        System.out.println(set1);
//        System.out.println(set2);
    }
}
