package zhuanxiang.backtracking;

import datastructure.search.Search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 698. 划分为k个相等的子集 https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 * 递归，回溯
 */
public class LC0698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(nums.length < k || k == 0 || nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == target){
            right--;
            k--;
        }

        return helper(new int[k], right, nums, target);

    }

    public boolean helper(int[] group, int right, int[] nums, int target){
        if(right < 0){
            return true;
        }
        int v = nums[right];
        right--;
        for (int i = 0; i < group.length; i++) {
            if(group[i] + v <= target){
                group[i] += v;
                if(helper(group, right, nums, target)){
                    return true;
                }
                group[i] -= v;
            }
            if(group[i] == 0){
                break;
            }
        }
        return false;

    }
}
