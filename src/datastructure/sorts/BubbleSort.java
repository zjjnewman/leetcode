package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2020-06-20
 * 冒泡排序
 * 参考 https://github.com/TheAlgorithms/Java/blob/master/Sorts/BubbleSort.java
 */
public class BubbleSort implements SortAlgorithm {

    /**
     * @param array 未排序的
     * @return array 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for(int i = 0; i < array.length; i++){
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j].compareTo(array[j+1]) > 0){
                    swap(array, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
        return array;
    }

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length; i++){
            boolean swapped = false;
            for (int j = 0; j < array.length - i -1; j++) {
                if(comparator.compare(array[j], array[j+1]) > 0){
                    swap(array, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return array;
    }



    public static void main(String[] args) {
        Character[] chars = {'d','a','o','e','b'};
        Integer[] integers = new Integer[]{7,5,84,67,36,74,87,32,94,32,6,35,64,237,43};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(integers)));
        System.out.println(Arrays.toString(bubbleSort.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }
                if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        })));
    }
}
