package datastructure.sorts;

import java.util.Comparator;

/**
 * heapSort 要求是完全二叉树，用数组表示，即使用树，树节点里还要加父亲节点的指针，暂时不与实现。
 *
 *
 * ----------留坑-----------
 */

public class HeapSort implements SortAlgorithm {
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
