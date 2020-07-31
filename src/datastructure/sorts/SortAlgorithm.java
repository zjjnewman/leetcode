package datastructure.sorts;

import java.util.Comparator;

/**
 * 各个排序算法 时间复杂度
 * 链接：https://www.nowcoder.com/questionTerminal/56eaafc76a6243ebb4c6a8428ca9a704
 * 来源：牛客网
 *
 * 排序方法              平均时间     最好时间     最坏时间
 * 桶排序(不稳定)         O(n)        O(n)        O(n)
 * 基数排序(稳定)         O(n)        O(n)        O(n)
 * 归并排序(稳定)         O(nlogn)    O(nlogn)    O(nlogn)
 * 快速排序(不稳定)       O(nlogn)    O(nlogn)    O(n^2)
 * 堆排序(不稳定)         O(nlogn)    O(nlogn)    O(nlogn)
 * 希尔排序(不稳定)       O(n^1.25)
 * 冒泡排序(稳定)         O(n^2)      O(n)        O(n^2)
 * 选择排序(不稳定)       O(n^2)      O(n^2)      O(n^2)
 * 直接插入排序(稳定)      O(n^2)      O(n)       O(n^2)
 */
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
