package datastructure.sorts;

import java.util.Comparator;

//二分插入排序，前提是已经有序的
public class BinaryInsertionSort implements SortAlghorithm{
    /**
     * @param array
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return array;
    }

    private <T> T binaryFindInsertIndex(T[] array){
        return null;
    }

    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }
}
