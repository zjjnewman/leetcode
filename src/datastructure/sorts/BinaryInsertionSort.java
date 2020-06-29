package datastructure.sorts;

/**
 * 决定应该在二分查找那里实现
 *
 * ----------留坑------------
 */

import java.util.Comparator;

//二分插入排序，前提是已经有序的
public class BinaryInsertionSort implements SortAlgorithm {
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
