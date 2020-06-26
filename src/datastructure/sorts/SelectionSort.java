package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort implements SortAlgorithm {
    /**
     * @param array
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmpMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j].compareTo(array[tmpMin]) < 0){
                    tmpMin = j;
                }
            }

            if(tmpMin != i){
                swap(array, i, tmpMin);
            }
        }
        return array;
    }

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {

        for (int i = 0; i < array.length; i++) {
            int tmpMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[j], array[tmpMin]) < 0){
                    tmpMin = j;
                }
            }
            if(tmpMin != i){
                swap(array, i, tmpMin);
            }
        }
        return array;
    }


    public static void main(String[] args) {
        Character[] chars = {'d','a','o','e','b'};
        Integer[] integers = new Integer[]{7,5,84,67,36,74,87,32,94,32,6,35,64,237,43};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sort(integers)));
    }
}
