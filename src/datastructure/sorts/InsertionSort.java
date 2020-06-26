package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort implements SortAlgorithm {
    /**
     * @param array
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(array[j].compareTo(array[j - 1]) < 0){
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }

    public static void main(String[] args) {
        Character[] chars = {'d','a','o','e','b'};
        Integer[] integers = new Integer[]{7,5,84,67,36,74,87,32,94,32,6,35,64,237,43};
        System.out.println(Arrays.toString(new InsertionSort().sort(integers)));
    }
}
