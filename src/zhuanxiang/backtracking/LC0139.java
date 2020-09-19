package zhuanxiang.backtracking;

import java.lang.reflect.Array;
import java.util.*;

public class  LC0139{
    static public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashSet<String> ans = new HashSet<>();
        dfs(s, 0, 1, set, ans);
        System.out.println(set);
        System.out.println(ans);
        for(String a : set){
            if(!ans.contains(a))return false;
        }
        return true;
    }

    static public void dfs(String s,int start,int end,HashSet<String> set, HashSet<String> ans){
        if(end > s.length()){
            if(!s.substring(start, end-1).equals("")){
                ans.add(s.substring(start, end-1));
            }
            return;
        }
//        if(!set.contains(s.substring(start, end))){
//            return;
//        }
        if(set.contains(s.substring(start, end))){
            ans.add(s.substring(start, end));
            start=end;
        }
        dfs(s, start, end+1, set, ans);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak("aaaaaaa", list));
        String[] ss = new String[0];
        ss[0] = "";
    }
}


