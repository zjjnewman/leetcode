package zhuanxiang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        dfs1(candidates,0,ans,combine,target);
        return ans;
    }

    public static void dfs(int[] candidates, int post, List<List<Integer>> ans, List<Integer> combine, int rest){
        if(post == candidates.length){
            return;
        }
        if(rest == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, post + 1, ans, combine, rest);
        if(rest - candidates[post] >= 0){
            combine.add(candidates[post]);
            dfs(candidates, post, ans, combine, rest - candidates[post]);
            combine.remove(combine.size()-1);
        }
    }

    public static void dfs1(int[] candidates, int post, List<List<Integer>> ans, List<Integer> combine, int rest){
        if(rest == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = post; i < candidates.length; i++) {
            if(rest - candidates[i] < 0){
                break;
            }
            combine.add(candidates[i]);
            dfs(candidates, i, ans, combine, rest - candidates[i]);
            combine.remove(combine.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

}
