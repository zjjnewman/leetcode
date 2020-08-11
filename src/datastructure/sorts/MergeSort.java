package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * mergeSort 的时间复杂度固定为nlogn，代码较为复杂，暂时留坑
 *
 * -------------留坑---------------
 */
public class MergeSort implements SortAlgorithm {






    private void merge(int[] arr, int low, int middle, int high){

        // 为新归并数组段，分配临时数组
        int[] tmp = new int[high - low + 1];

        // 把临时数组初始化为 arr[low, high]闭区间归并段的数据
        for (int i = low; i <= high; i++) {
            tmp[i - low] = arr[i];
        }

        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if(i > middle && j <= high){
                arr[k] = tmp[j - low];
                j++;
            } else if (i <= middle && j > high){
                arr[k] = tmp[i - low];
                i++;
            } else if (tmp[i - low] > tmp[j - low]){
                arr[k] = tmp[j - low];
                j++;
            } else if (tmp[i - low] <= tmp[j - low]){// 这里的等号记录下，很关键，若没有的话出错
                arr[k] = tmp[i - low];
                i++;
            }
        }

        for (int k = low; k <= high; k++) {
            System.out.print(arr[k] + "  ");
        }
        System.out.println("\n");
    }

    public void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }

        int middle = (high + low) / 2;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, high);
        merge(arr, low, middle, high);
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

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] integers = new int[]{84,7,5,67,36, 74, 87, 32, 94, 32, 6, 35, 64, 237, 43};
        m.mergeSort(integers, 0, 14);
        System.out.println("[84, 7, 5, 67, 36, 74, 87, 32, 94, 32, 6, 35, 64, 237, 43]");
        System.out.println(Arrays.toString(integers));
    }
}
