package qiuzhao.qunawang;

import java.math.BigInteger;
import java.util.*;

public class T1 {
    
    static void dfs(int m, int n, int post, Set<List<Integer>> ans, List<Integer> combine){
        if(post > m){
            return;
        }
        if(combine.size() == n){
            Collections.sort(combine);
            ans.add(new ArrayList<>(combine));
            return;
        }
        if(!combine.contains(new Integer(post))){
            combine.add(post);
            dfs(m, n, post, ans, combine);
            combine.remove(combine.size()-1);
        }
        dfs(m,n,post+1,ans,combine);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(m<n){
            System.out.println(0);
            return;
        }
        if(n==m){
            System.out.println(1);
            return;
        }

//        long[] dp = new long[n+1];
        BigInteger[] dp = new BigInteger[n+1];
        for (int i = 1; i <=n; i++) {
            dp[i]=new BigInteger("0");
        }
        dp[0] = new BigInteger("1");
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1 ; j--) {
                dp[j] = dp[j].add(dp[j-1]);
            }
        }
        System.out.println(dp[n].toString());
    }
}
