package leetcode.bytedance.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 上接 4. 寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 二分查找，觉得这种直接找上下边界的答题方式很清晰，比奇淫巧技更具有推广性
 */
public class LC0034 {
    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid;
        int idx = -1;

        while (low <= high){
            mid = low + (high - low)>>>1;
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


    //上面的解法不能很符合题意，如若全部数组都是target 则算法时间复杂度退化成o(n)
    //所以下面给出logn的本质解法，不要什么花里胡哨，只要本质。
    public int lowBound(int[] nums, int target){
        /**
         * 下边界满足条件：
         * 1. 下边界 = target
         * 2. 下边界左边 != target
         *      1. 下边界的左边有数，且小于target
         *      2. 下边界的左边没数，即8是第一个数
         */
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high){
            //这里>>>有个坑，他比运算符优先级都要小，所以要加括号
            mid = low + ((high - low)>>>1);

            if(target == nums[mid] && (mid == 0 || target > nums[mid - 1])){
                return mid;
            } else if(target > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int highBound(int[] nums, int target){
        /**
         * 上边界满足：
         * 1. 必有 上边界值 == target
         * 2. 上边界值 的右边必须不等于上边界
         *      1. 若target 右边有数，必有右边大于target
         *      2. 若target 右边没数，target为length - 1
         */
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high){
            //这里>>>有个坑，他比运算符优先级都要小，所以要加括号
            mid = low + ((high - low)>>>1);
            if(target == nums[mid] && (mid == nums.length - 1 || nums[mid + 1] > target)){
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
        LC0034 lc0034= new LC0034();
        int[] ints = new int[] {5,7,7,8,8,10};
        int[] is = new int[]{1,1,2};
//        System.out.println(Arrays.toString(lc0034.searchRange(is, 1)));

        System.out.println(lc0034.lowBound(is, 1));
        System.out.println(lc0034.highBound(is, 1));
//        System.out.println((10 - 2 )>>>1 + 2);
    }
}
