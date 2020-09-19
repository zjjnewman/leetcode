package zhuanxiang.backtracking;

/**
 * 377. 组合总和 Ⅳ https://leetcode-cn.com/problems/combination-sum-iv/
 * 这里也是动态规划的问题
 *
 */
public class LC0377 {

    public static int cnt = 0;
    public static int combinationSum4(int[] nums, int target) {
        dfs(nums,target);
        return cnt;
    }

    public static void dfs(int[] nums, int target){
        if(target == 0){
            cnt++;
            return;
        }
        for(int i = 0; i < nums.length; i++){
            dfs(nums, target- nums[i]);
        }
    }

    public static void main(String[] args) {
        combinationSum4(new int[]{1, 2, 3}, 4);
    }

}
