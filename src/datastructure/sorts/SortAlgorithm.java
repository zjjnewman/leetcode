package datastructure.sorts;

import java.util.Comparator;

public interface SortAlgorithm {

    /**
     *
     * @param unsorted
     * @param <T>
     * @return 已经排序的
     */
    public <T extends Comparable<T>> T[] sort(T[] unsorted);


    //策略模式，传入比较器
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator );

    //数组用的交换方法
    default <T> void swap(T[] array, int indexA, int indexB){
        T tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
}
