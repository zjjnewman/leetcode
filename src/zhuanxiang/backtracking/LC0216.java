package zhuanxiang.backtracking;


import java.util.*;

/**
 * 216. 组合总和 III https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class LC0216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        HashSet<List<Integer>> trans = new HashSet<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(n<=0){
            return ans;
        }

        ArrayList<Integer> combine = new ArrayList<>();
        boolean[] visited = new boolean[10];
        dfs(visited, k, n, trans, combine);
        ans = new ArrayList<>(trans);
        return ans;

    }

    public boolean dfs(boolean[] visited, int cnt, int rest, Set<List<Integer>> ans, List<Integer> combine){
        if(cnt == 0 && rest==0){
            ArrayList<Integer> list = new ArrayList<>(combine);
            Collections.sort(list);
            ans.add(list);
            return true;
        }
        boolean r=false;
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && rest - i < 0){
                return false;
            }
            if(!visited[i]){
                visited[i]=true;
                combine.add(i);
                r = dfs(visited, cnt-1, rest - i, ans, combine);
                visited[i]=false;
                combine.remove(combine.size()-1);
            }
        }
        return r;
    }
}
