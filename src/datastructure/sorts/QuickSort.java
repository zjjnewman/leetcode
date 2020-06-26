package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 快排参考 https://www.cnblogs.com/ioio2/p/9038277.html 给出了栈和递归的方式
 */
public class QuickSort implements SortAlgorithm {
    /**
     * @param array
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }


    // 递归的解法

    public <T extends Comparable<T>> void quickSort(T[] array, int l, int r){

        if(l >= r){
            return;
        }

        int low = l, high = r;

        while (low < high){
            while (low < high && array[low].compareTo(array[high]) <= 0){
                high--;
            }
            if(low < high){
                swap(array, low, high);
            }

            while (low < high && array[low].compareTo(array[high]) <= 0){
                low++;
            }
            if(low < high){
                swap(array, low, high);
            }
        }
        quickSort(array, l, low - 1);
        quickSort(array, low + 1, r);
    }



    public <T extends Comparable<T>> void quickSort1(T[] array, int low, int high){
        if(low >= high){
            return;
        }
        int refIdx = part(array, low, high);
        quickSort1(array, low, refIdx - 1);
        quickSort1(array, refIdx + 1, high);
    }

    public <T extends Comparable<T>> int part(T[] array, int low, int high){
        if(low >= high){
            return -1;
        }
        while (low < high){
            while (low < high && array[low].compareTo(array[high]) <= 0){
                high--;
            }
            if(low < high){
                swap(array, low, high);
            }

            while (low < high && array[low].compareTo(array[high]) <= 0){
                low++;
            }
            if(low < high){
                swap(array, low, high);
            }
        }
        return low;
    }




    // 栈的解法

    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }




    public static void main(String[] args) {
        Character[] chars = {'d','a','o','e','b'};
        Integer[] integers = new Integer[]{84,7,5,67,36,74,87,32,94,32,6,35,64,237,43};
        QuickSort qs = new QuickSort();
        qs.quickSort(integers, 0, 14);
        System.out.println(Arrays.toString(integers));
    }
}
