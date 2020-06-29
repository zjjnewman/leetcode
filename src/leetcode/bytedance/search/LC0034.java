package leetcode.bytedance.search;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 上接 4. 寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 二分查找
 */
public class LC0034 {
    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid;
        int idx = -1;

        while (low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                idx = mid;
                break;
            } else if(target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if(idx != -1){
            low = idx;
            high = idx;

            // 这里条件一开始忽略了==0，导致纠结了好长时间
            while (low - 1 >= 0 && target == nums[low - 1]){
                low--;
            }

            while (high + 1 < nums.length && target == nums[high + 1]){
                high++;
            }

            return new int[]{low, high};

        } else {
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        LC0034 lc0034= new LC0034();
        int[] ints = new int[] {5,7,7,8,8,10};
        int[] is = new int[]{1};
        System.out.println(Arrays.toString(lc0034.searchRange(is, 1)));
    }
}
