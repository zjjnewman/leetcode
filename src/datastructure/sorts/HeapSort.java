package datastructure.sorts;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * heapSort 要求是完全二叉树，用数组表示，即使用树，树节点里还要加父亲节点的指针，暂时不与实现。
 *
 *
 * ----------留坑-----------
 */

public class HeapSort implements SortAlgorithm {
    /**
     * 堆排序是 不稳定 排序
     *
     * 先不用通用的数据结构解决，因为堆是完全二叉树，所以用数组表示
     * 需要实现两个方法：
     *      1.对数组大顶堆化或小顶堆化
     *      2.每次去除堆顶，重新对剩下的元素堆化，然后迭代进行
     * 堆排序的要点是，完全二叉树在数组的规律，若index始于0，父节点的 index = i 则其：
     *      1.左孩子 index = 2i+1
     *      2.右孩子 index = 2i+2
     *
     */

    // 堆排序
    public void heapSort(Integer nums[], int low, int high){
        makeBigHeap(nums, low, high);

        while (high >= low){
            swap(nums, low, high);
            high--;
            downSift(nums, low, high);
        }
    }

    /**
     * 有bug，需要判断边界条件 array.len == 1的条件
     * @param array
     */
    public void makeBigHeap(Integer[] array, int low, int high){
        // 每一个叶子节点可以视为一个 大顶堆，然后针对倒数第一个父节点，作为需要调整的堆头结点，调用上面方法
        // 倒数第一个父节点的计算方法为  (array.length - 1 - 1)/2
        if(high >= array.length || low < 0){
            return;
        }

        int lastFather = (high - 1)/2;
        for (int i = lastFather; i >= low; i--) {
            downSift(array, i, high);
        }
    }

    // 针对头结点的,堆向下调整
    public void downSift(Integer[] array, int low, int high){
        // father为起始点
        int father = low;
        // father 的左孩子
        int child = (father << 1) + 1;
        while (child <= high){
            // 如果右孩子比左孩子大，记下右孩子
            if(child < high && array[child] < array[child + 1]){
                child++;
            }

            // 如果不满足大顶堆，交换父亲和孩子位置
            if(array[father] < array[child]){
                swap(array, father, child);
                // 接着调整换下来的点
                father = child;
                child = (father << 1) + 1;
            } else { //否则满足堆定义，无需调整
                break;
            }
        }
    }


    /**
     * 补充，还有个向上调整，即考虑在数组中追加元素的时候，就需要向上调整
     * （数组中拿取堆头元素，是向下调整）
     */
    // 大顶堆向上调整（在数组后面追加元素）
    public void upSift(Integer[] nums, int low, int high){
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


    public static void main(String[] args) throws IOException {
        HeapSort heapSort = new HeapSort();
        // 堆化后序列为 [97, 76, 65, 49, 49, 13, 27, 38]
//        Integer[] is = new Integer[]{49, 38, 65, 97, 76, 13, 27, 49};
        Integer[] is = new Integer[]{49};
        heapSort.makeBigHeap(is, 0, 0);
        System.out.println(Arrays.toString(is));

    }







    /**
     * @param unsorted
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return null;
    }

    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }
}
