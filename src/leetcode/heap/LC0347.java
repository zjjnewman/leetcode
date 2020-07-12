package leetcode.heap;

import com.sun.tools.javac.code.Attribute;

import java.util.*;

/**
 * 堆排序
 * 347.前K个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class LC0347 {

    class ValueFreq {
        private int val;
        int freq;

        public ValueFreq(){};
        public ValueFreq(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }



    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        PriorityQueue<Integer> heap1 = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));



        // 原来比较器可以这么用？ 可以传进去外部方法的变量 map ----- 类内 new lei时 内部new出的对象内重写方法，都可以调用对象外 类内的变量 和方法
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = nums[1];
                return map.get(o2) - map.get(o1);
            }
        });

        for (Integer num : map.keySet()) {
            heap.add(num);
        }

        int i = 0;
        int[] topKs = new int[k];

        while (i < k){
            topKs[i] = heap.poll();
            i++;
        }
        return topKs;
    }



    public int[] topKFrequent1(int[] nums, int k) {
        /**
         * 初步分析，可以以出现的频率为堆排序的参考值，建立大顶堆，去除k个元素，
         * 如何获取每个数出现的频率？可以建立一个类 存放值，和出现频率，遍历数组得到
         *
         * 不过上面的分析太麻烦，不如堆排序，然后遍历整个排序好的数组
         */

        if(k >= nums.length){
            return nums;
        }

        heapSort(nums, 0, nums.length - 1);

        PriorityQueue<ValueFreq> heap = new PriorityQueue<>(new Comparator<ValueFreq>() {
            @Override
            public int compare(ValueFreq o1, ValueFreq o2) {
                return o2.freq - o1.freq;
            }
        });

        for (int i = 0; i < nums.length - 1; i++) {
            int freq = 1;
            while (nums[i] == nums[i + 1]){
                freq++;
                i++;
            }
            heap.offer(new ValueFreq(nums[i], freq));
        }

        int[] ks = new int[k];

            for (int i = 0; i < k; i++) {
                if(heap.peek() != null){
                    ks[i] = heap.poll().getVal();
                } else {
                    break;
                }
            }

        return ks;
    }

    // 堆排序
    public void heapSort(int nums[], int low, int high){
        makeBigHeap(nums, low, high);

        while (high >= low){
            swap(nums, low, high);
            high--;
            downSift(nums, low, high);
        }
    }

    // 构建大顶堆
    public void makeBigHeap(int[] nums, int low, int high){
        if(high >= nums.length || low < 0){
            return;
        }
        int lastFather = (high - 1)/2;
        for (int i = lastFather; i >= low; i--) {
            downSift(nums, i, high);
        }
    }

    // 大顶堆向下调整
    public void downSift(int[] nums, int low, int high){
        int father = low;
        int child = father * 2 + 1;
        while (child <= high){
            if(child < high && nums[child] < nums[child+1]){
                child++;
            }

            if(nums[father] < nums[child]){
                swap(nums, child, father);
                father = child;
                child = father * 2 + 1;
            } else {
                break;
            }
        }
    }

    // 大顶堆向上调整（在数组后面追加元素）
    public void upSift(int[] nums, int low, int high){

        int child = high;
        int father = (child - 1)/2;
        while (father >= low){
            if(nums[child] > nums[father]){
                swap(nums, child, father);
                child = father;
                father = (child - 1)/2;
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
        LC0347 lc = new LC0347();
//        // 堆化后序列为 [97, 76, 65, 49, 49, 13, 27, 38]
////        int[] is = new int[]{97, 76, 65, 49, 49, 13, 27, 38, 80};
//        // 向上调整后排序 [97, 80, 65, 76, 49, 13, 27, 38, 49]
//
        int[] is = new int[]{49, 38, 65, 97, 80, 76, 13, 27, 49};
////        int[] is = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
//        int[] is = new int[]{49};
//        lc.makeBigHeap(is, 0, 0);
////        lc.heapSort(is, 0, 7);
////        lc.upSift(is, 0, 8);
//
//        System.out.println(Arrays.toString(is));

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        hashMap.put(5, 1);
//        hashMap.put(1, 1);
//        hashMap.put(2, 1);
//        hashMap.put(4, 1);
//
//        hashMap.keySet().forEach(System.out::println);

        lc.topKFrequent(is, 1);

    }

}
