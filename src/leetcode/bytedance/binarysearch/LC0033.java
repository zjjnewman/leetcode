package leetcode.bytedance.binarysearch;

/**
 * 33. 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 二分搜索
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 */
public class LC0033 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high){
            mid = low + ((high - low)>>>1);

            if(target == nums[mid]){
                return mid;
            }

            // 满足条件说明 mid左边排好序，若不满足，说明mid 右边排好序
            if(nums[low] <= nums[mid]){
                //在左边有序的情况下

                //若target在 左中值之间，查找左边，失败返回-1；
                if(target >= nums[low] && target < nums[mid]){
                    return binarySearch(nums, target, low, mid - 1);
                }

                //若targe 比 tnums[low]值小，则应搜索右半边
                //若比mid值大，搜索右半边
                if(target < nums[low] || target > nums[mid]){
                    low = mid + 1;
                }

            }


            /**
             * 这里关于下面注释了代码的边界，属于low mid 之间的左边界，所以应该归为 nums[low] <= nums[mid]的状况
             */
//            else if(nums[low] == nums[mid]){
//                if(nums[low])
//            }
            else {
                //如果不满足条件，说明mid 右边排好序，
                //如果target在右边区间
                if(target > nums[mid] && target <= nums[high]){
                    return binarySearch(nums, target, mid + 1, high);
                }

                //如果不在右边区间，搜索左区间
                //如果比mid值大
                if(target < nums[mid] || target > nums[mid]){
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target, int low, int high){

        int mid;

        while (low <= high){
            mid = low +((high - low)>>>1);

            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[] {5,7,7,8,8,10};
        int [] ints1 = {3,4,5,6,1,2};
        int[] ints3 = {3,1};
        System.out.println(new LC0033().search(ints3, 1));
    }

}
