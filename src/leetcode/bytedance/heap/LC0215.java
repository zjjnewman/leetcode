package leetcode.bytedance.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 用的是 PriorityQueue 做的大顶堆或者小顶堆
 */
public class LC0215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> numsHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            numsHeap.offer(nums[i]);
        }

        int kTh = 0;
        for (int i = 0; i < k; i++) {
            kTh = numsHeap.poll();
        }

        return kTh;
    }

    // 堆排序
    public int heapSortForKth(int[] nums, int k){
        makeMaxHeap(nums);
        for (int i = 1; i <= k ; i++) {
            swap(nums, 0, nums.length - i);
            upSift(nums, 0, nums.length - i - 1);
        }

        return nums[nums.length - k];
    }


    // 大顶堆堆化
    public void makeMaxHeap(int[] nums){
        if(nums.length == 1){
            return;
        }
        int firstFatherIdx = (nums.length - 1 - 1)>>>1;
        for (int i = firstFatherIdx; i >= 0; i--) {
            upSift(nums, i, nums.length - 1);
        }
    }

    // 针对顶点的小顶堆调整
    public void downSift(int[] nums, int low, int high){
        // 要调整的点
        int i = low;
        // 左孩子
        int j = (low << 1) + 1;
        // 若j没有到树底就一直 从上到下 调整
        while (j <= high){
            if(j < high && nums[j] < nums[j+1]){
                j++;
            }

            //
            if(nums[i] > nums[j]){
                swap(nums, i, j);
                i = j;
                j = (i << 1) + 1;
            } else { //若不需要调整，就得到了最终位置，结束
                break;
            }
        }
    }

    // 大顶堆
    public void upSift(int[] nums, int low, int high){
        int i = low;
        int j = (low << 1) + 1;
        while (j <= high){
            if(j < high && nums[j] < nums[j+1]){
                j++;
            }
            if(nums[i] < nums[j]){
                swap(nums, i, j);
                i = j;
                j = (i << 1) + 1;
                System.out.println(j);
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LC0215 lc = new LC0215();
//        // 堆化后序列为 [97, 76, 65, 49, 49, 13, 27, 38]
//        Integer[] is = new Integer[]{49, 38, 65, 97, 76, 13, 27, 49};
//        int[] is = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        int [] is = new int[]{1,2};
        lc.makeMaxHeap(is);
        System.out.println(Arrays.toString(is));
    }
}
