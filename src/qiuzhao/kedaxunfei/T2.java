package qiuzhao.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    static void swap(int[] array, int indexA, int indexB){
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

    static public void quickSort(int[] array, int l, int r){
        if(l >= r){
            return;
        }
        int low = l, high = r;

        while (low < high){
            while (low < high && array[low]<=array[high]){
                high--;
            }
            if(low < high){
                swap(array, low, high);
            }

            while (low < high && array[low] <= array[high]){
                low++;
            }
            if(low < high){
                swap(array, low, high);
            }
        }
        quickSort(array, l, low - 1);
        quickSort(array, low + 1, r);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            quickSort(nums,0,nums.length-1);

            for (int num : nums) {
                System.out.print(num+" ");
            }

        }
    }
}
