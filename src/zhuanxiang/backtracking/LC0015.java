package zhuanxiang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 */

public class LC0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> add = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, 3, 0, ans, add);
        return ans;
    }

    public static void dfs(int[] nums, int post, int cnt, int sum, List<List<Integer>> ans, List<Integer> add){
        if(cnt == 0 && sum == 0){
            ans.add(new ArrayList<>(add));
            return;
        }
        if(cnt < 0){
            return;
        }

        for(int i = post; i < nums.length; i++){

            if(sum > 0 && nums[post] >= 0){
                break;
            }

            if(i > post&&nums[i] == nums[i - 1]){
                continue;
            }
            add.add(nums[i]);
            dfs(nums, i+1,cnt - 1,sum+nums[i],ans,add);
            add.remove(add.size()-1);
        }
    }
}
