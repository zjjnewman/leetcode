package qiuzhao.zuiyou;

import java.util.*;

public class T1 {

    public static void dfs(String[] ss, Set<Long> ans, String combine){
        if(combine.length() == ss.length){
            long l = Long.parseLong(combine);
            ans.add(l);
            return;
        }
        for (int i = 0; i < ss.length; i++) {
            if(i > 0 && ss[i].equals(ss[i-1])){
                continue;
            }
            if(!ss[i].equals("*")){
                String s = ss[i];
                ss[i] = "*";
                combine = combine + s;
                dfs(ss, ans, combine);
                ss[i] = s;
                combine = combine.substring(0,combine.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ss[i] = String.valueOf(s.charAt(i));
        }

        Set<Long> ans = new HashSet<>();
        String combine = "";
        dfs(ss, ans, combine);

        ArrayList<Long> arr = new ArrayList<>(ans);

        Collections.sort(arr);

        for (Long an : arr) {
            String r = String.valueOf(an);
            while (r.length() != s.length()){
                r = "0"+ r;
            }
            System.out.print(r +" ");
        }

    }
}
