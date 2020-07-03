package leetcode.bytedance.binarysearch;

/**
 * 4. 寻找两个正序数组的中位数  困难  https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 此题涉及到 二分搜索，由此我先复习并实现了二分查找数组，在类 datastructure.search.BinarySearch
 * 由此我看了 https://www.bilibili.com/video/BV1SK411V7Lq?p=8 这个视频，其中提到了力扣第34题
 * 决定先实现34题
 *
 *
 * -------------此题无坑，但有瓜，需要好好品尝---------------
 */
public class LC0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         * 考虑用二分查找
         * 假设la+lb=L
         * 若 L 是奇数 中位数是二者中第 L/2+1 小的数
         * 若 L 是偶数 中位数是二者中第 L/2 L/2+1 小的数
         *
         * 分析：有4种状况，其中2个极端，2个折中
         * 1. A 全部大于 B
         *      若为奇数
         *          那么中位数在A中 第 L/2-la 个数
         *      若为偶数
         *          那么中位数在A中 第 L/2-la L/2+1-la个数
         *
         * 2. A 全部小于 B
         *      同上
         *
         *
         * 3. A的中位数a 大于等于 B的中位数b
         *
         *
         * 4. A的中位数a 小于 B的中位数b
         *
         * 可以肯定的是，若是 1 2条件，A B合成的新数组中位数，绝对在a b之间
         * 需要验证 3 4条件下，A B 合成数组的中位数 是否在 a b 之间
         */
        int m = nums1.length;
        int n = nums2.length;

        int k = (m + n) / 2;

        if((m + n) % 2 == 1){
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, k + 1);
        } else {
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, k) +
                    findKth(nums1, 0, m - 1, nums2, 0, n - 1, k+1))
                    /2.0;
        }
    }



    public int findKth(int[] nums1, int low1, int high1,
                       int[] nums2, int low2, int high2, int k){
        int m = high1 - low1 + 1;
        int n = high2 - low2 + 1;

        if(m > n){
            return findKth(nums2, low2, high2, nums1, low1, high1, k);
        }

        if(m == 0){
            return nums2[low2 + k - 1];
        }

        //以下是抄的
        if(k == 1){
            return Math.min(nums1[low1], nums2[low2]);
        }

        // 处理完二者的特殊情况，一般状况下，求

        //为什么会求二者的最小值？？
        int k1 = Math.min(k/2, m);
        int k2 = k - k1;

        int val1 = nums1[low1 + k1 - 1];
        int val2 = nums2[low2 + k2 - 1];

        if(val1 == val2){
            return val1;
        }else if(val1 < val2){
            //这里留意 k下标怎么取
            return findKth(nums1, low1 + k1, high1, nums2, low2, low2 + k2 - 1, k - k1);
        }else{
            return findKth(nums1, low1, low1  + k1 - 1, nums2, low2 + k2, high2, k - k2);
        }
    }
}
