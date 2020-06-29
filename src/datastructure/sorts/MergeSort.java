package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * mergeSort 的时间复杂度固定为nlogn，代码较为复杂，暂时留坑
 *
 * -------------留坑---------------
 */
public class MergeSort implements SortAlgorithm {
    /**
     * @param unsorted
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return null;
    }

    public <T extends Comparable> void mergeSort(T[] array, int low, int mid, int high){
        if(low >= high){
            return;
        }


        if((low+1) == mid){
            if(array[low].compareTo(array[high]) > 0){
                swap(array, low, high);
            }
            return;
        }


        int l = low;
        int r = high;
        int m1 = (low + mid)/2;
        int m2 = (mid + high)/2;
//        mergeSort(array, low, mid);
//        mergeSort(array, mid + 1, high);
    }


    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Integer[] integers = new Integer[]{84,7,5,67,36,74,87,32,94,32,6,35,64,237,43};
//        m.mergeSort(integers, 0, 14);
        System.out.println("[84, 7, 5, 67, 36, 74, 87, 32, 94, 32, 6, 35, 64, 237, 43]");
        System.out.println(Arrays.toString(integers));
    }
}
