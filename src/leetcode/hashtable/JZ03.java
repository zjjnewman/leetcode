package leetcode.hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 面试题03. 数组中重复的数字 https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */

public class JZ03 {

    class Solution {
        public int findRepeatNumber(int[] nums) {
            int a = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(nums[i])){
                    return nums[i];
                }
                map.put(nums[i], i);
            }
            return Integer.MAX_VALUE;
        }



        public int findRepeatNumber1(int[] nums) {
            return Integer.MAX_VALUE;
        }
    }

}
