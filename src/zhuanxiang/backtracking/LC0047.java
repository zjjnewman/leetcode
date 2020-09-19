package zhuanxiang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class LC0047 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cell = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        dfs(nums, 0, ans, cell,visit);
        return ans;
    }

    public static void dfs(int[] nums, int post, List<List<Integer>> ans, List<Integer> cell, boolean[] visit){

        if(cell.size() == nums.length){
            ans.add(new ArrayList<>(cell));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                //判断上次是否用过，上次没用过，则这次这个可以用
                if(visit[i-1]);
                else continue;
            }
            if(!visit[i]){
                cell.add(nums[i]);
                visit[i] = true;
                dfs(nums, i + 1, ans, cell, visit);
                visit[i] = false;
                cell.remove(cell.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
