package datastructure.sorts;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIFactoryMethod;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

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


    // 针对头结点点的堆调整
    public void adjustHeadNodeForBigHeap(Integer[] array, int low, int high){
        // i为起始点
        int i = low;
        // i 的左孩子
        int j = (i << 1) + 1;
        while (j <= high){
            // 如果右孩子比左孩子大，记下右孩子
            if(j < high && array[j] < array[j+1]){
                j++;
            }

            // 如果不满足大顶堆，交换父亲和孩子位置
            if(array[i] < array[j]){
                swap(array, i, j);
                // 接着调整换下来的点
                i = j;
                j = (i << 1) + 1;
            } else { //否则满足堆定义，无需调整
                break;
            }
        }
    }

    public void makeBigHeap(Integer[] array){
        // 每一个叶子节点可以视为一个 大顶堆，然后针对倒数第一个父节点，作为需要调整的堆头结点，调用上面方法
        // 倒数第一个父节点的计算方法为  (array.length - 1 - 1)/2
        for (int i = ((array.length - 1 - 1)>>>1); i >= 0 ; i--) {
            adjustHeadNodeForBigHeap(array, i, array.length - 1);
        }
    }

    public static void main(String[] args) throws IOException {
//        HeapSort heapSort = new HeapSort();
//        // 堆化后序列为 [97, 76, 65, 49, 49, 13, 27, 38]
//        Integer[] is = new Integer[]{49, 38, 65, 97, 76, 13, 27, 49};
//        heapSort.makeBigHeap(is);
//        System.out.println(Arrays.toString(is));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(System.out)));
        while (true){
            String s = bufferedReader.readLine();
            s = s.trim();
            s = s.replaceAll("\\s+", ",");
            bufferedWriter.write(s);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        }

//        String[] ss = s.split(",");
//        System.out.println(Integer.parseInt(ss[0]));

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
