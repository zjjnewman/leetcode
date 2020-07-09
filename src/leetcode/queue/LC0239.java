package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 双端队列，也可以称之为单调栈
 *
 * 239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 这个维护逻辑就是单调栈（Monotonous Stack，也可以说是单调队列）。本题根据题设，是要求栈上元素只能单调递减，
 * 即[5,4,3,1]是一个有效的单调栈状态，当遇到了新元素2，则不能直接压栈（否则就不单调递减了），必须先把比2小的元素（即末尾的1）弹出，
 * 再压栈——[5,4,3,2]。在题目中，实际上栈中的元素总是滑动窗口元素的子集（因为可能有弹出操作），所以栈顶元素必然是窗口的最大值。
 * 但是随着窗口移动，栈顶需要退出窗口，所以，题解在维护单调栈的时候用的是元素下标，而非元素实际的值，就是为了判断栈顶何时出栈
 * （当窗口左端已经pass栈顶下标的时候）。
 *
 *
 * 可能会比较疑惑单调栈为什么能解决问题。单调栈的典型用途是用于找到数组中下一个比自身大的元素（the next greater element, NGE），
 * 可以在一次遍历就获得所有元素的NGE。而我们以[5,4,3,1]->[5,4,3,2]为例，其实弹出1是因为可以明确知道3~2之间的所有元素都比3和2小，
 * 那么他们的值是多少其实已经无所谓了，在任何时候他们都不会是结果集中的一员（向左有3，向右有2，轮不到中间的元素）。
 *
 * 单调栈的思维很精巧也很高效，是比较高级的栈维护技巧。以下题目类似：
 *
 *     907. Sum of Subarray Minimums
 *     739. Daily Temperatures
 *     503. Next Greater Element II
 *
 * --- 2020.06.14 update ---
 *
 * 有同学对于栈和队列方面还有疑问，贴个具体实现吧。其实栈或队列无关紧要，和单调维护方式一样，都是使用方法罢了。具体实现上用链表即可（其实环形数组也是可以的）。
 *
 */
public class LC0239 {


    // 双端队列法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return nums;
        }

        if(k >= nums.length){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }

        // 准备数据结构
        // 双端队列,队头存储当前窗口，索引范围内的最大值，
        Deque<Integer> deque = new ArrayDeque<>();
        // 窗口最大值数组
        int[] maxArr = new int[nums.length - k + 1];


        /*
        // 初始化首个窗口
        for (int i = 0; i < k; i++) {

            // 如果队列为空就 队尾压入数据
            if(deque.isEmpty()){
                deque.offerLast(i);
            }

            // 把 i 索引压入队尾，但是要满足下面条件
            // 如果要压入队尾的数 大于 当前队尾，循环弹出队尾，直到不满足条件，压入要压入队尾的数
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.pollLast();
            }
            // 如果队列为空就 || 要加入的数 小于等于 队尾，压入数的下标
            deque.offerLast(i);
        }
        maxArr[0] = nums[deque.peekFirst()];
        */


        /**
         * (经过上面的初始化，当前窗口的最大值在队首，保持下面所有窗口的最大值在队首，移除队首的情况是
         * 当前队首下标，超过了当前窗口下标范围)
         */
        for (int i = 0, j = 0; i < nums.length; i++) {
            int low = 0;
            if(i >= k){
                low = i - k + 1;
                j++;
            }
            int high = i;


            if(!deque.isEmpty() && deque.peekFirst() < low){
                deque.pollFirst();
            }
            clearAndAdd(nums, deque, high);
            maxArr[j] = nums[deque.peekFirst()];
        }

        return maxArr;
    }

    public void clearAndAdd(int[] nums, Deque<Integer> deque, int high){

        // 把 i 索引压入队尾，但是要满足下面条件
        // 如果要压入队尾的数 大于 当前队尾，循环弹出队尾，直到不满足条件，压入要压入队尾的数
        while (!deque.isEmpty() && nums[high] > nums[deque.peekLast()]){
            deque.pollLast();
        }
        deque.offerLast(high);
    }

    public static void main(String[] args) {
        LC0239 lc = new LC0239();
//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = new int[]{7,2,4};
        System.out.println(Arrays.toString(lc.maxSlidingWindow(nums, 2)));
    }
}
