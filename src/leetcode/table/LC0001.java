package leetcode.table;

import java.util.HashMap;

/**
 *
 * @date 2020-06-15
 * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 */

public class LC0001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map =  new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                map.put(nums[i], i);
            }

//            for (int i = 0; i < target; i++){
//                if(map.get(i) != null && map.get(target - i) != null){
//                    return new int[]{map.get(i),map.get(target - i)};
//                }
//            }

            for(int i = 0; i < nums.length; i++){
                int  b = target - nums[i];
                if(map.containsKey(b) && map.get(b) != i){
                    return new int[]{i, map.get(b)};
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        map.put(3,0);
        map.put(3,1);
        System.out.println(map.size());
    }
}
