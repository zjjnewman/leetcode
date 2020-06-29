package leetcode.bytedance;

/**
 * 4. 寻找两个正序数组的中位数  困难  https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 此题涉及到 二分搜索，由此我先复习并实现了二分查找数组，在类 datastructure.search.BinarySearch
 * 由此我看了 https://www.bilibili.com/video/BV1SK411V7Lq?p=8 这个视频，其中提到了力扣第34题
 * 决定先实现34题
 *
 *
 * -------------此题留坑---------------
 */
public class LC0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         * 考虑用二分查找
         * 分析：有4种状况，其中2个极端，2个折中
         * 1. A 全部大于 B
         * 2. A 全部小于 B
         * 3. A的中位数a 大于等于 B的中位数b
         * 4. A的中位数a 小于 B的中位数b
         *
         * 可以肯定的是，若是 1 2条件，A B合成的新数组中位数，绝对在a b之间
         * 需要验证 3 4条件下，A B 合成数组的中位数 是否在 a b 之间
         */

        return 0;
    }
}
