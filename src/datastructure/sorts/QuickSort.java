package datastructure.sorts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 快排参考 https://www.cnblogs.com/ioio2/p/9038277.html 给出了栈和递归的方式
 */
public class QuickSort implements SortAlghorithm {
    /**
     * @param array
     * @return 已经排序的
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int low = 0;
        int high = array.length - 1;
        T tmp = array[low];
        /**
         *             while(low<hign){
         *                 while(low<hign&&array[hign]>=tmp){
         *                     --hign;
         *                 }
         *                 if(low>=hign){
         *                     break;
         *                 }else{
         *                     array[low]=array[hign];
         *                 }
         *                 while(low<hign&&array[low]<=tmp){
         *                     ++low;
         *                 }
         *                 if(low>=hign){
         *                     break;
         *                 }else{
         *                     array[hign]=array[low];
         *                 }
         *
         *         }
         *             array[low]=tmp;
         *             return low;
         */
        while (low < high){
            while (low < high && tmp.compareTo(array[high]) >= 0){
                high--;
            }
            if(low >= high){
                break;
            }else {
                array[low] = array[high];
            }

            while (low < high && tmp.compareTo(array[high]) >= 0){
                low++;
            }
            if(low >= high){
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return array;
    }



    @Override
    public <T> T[] sort(T[] unsorted, Comparator<T> comparator) {
        return null;
    }

    public static void main(String[] args) {
        Character[] chars = {'d','a','o','e','b'};
        Integer[] integers = new Integer[]{84,7,5,67,36,74,87,32,94,32,6,35,64,237,43};
        System.out.println(Arrays.toString(new QuickSort().sort(integers)));
    }
}
