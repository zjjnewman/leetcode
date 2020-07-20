package leetcode.search.binarysearch;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * 指 Offer 11. 旋转数组的最小数字 https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 */
public class JZ11 {
    public int minArray(int[] numbers) {

        if(numbers.length == 0){
            return Integer.MIN_VALUE;
        }
        if(numbers.length == 1){
            return numbers[0];
        }

        int low = 0;
        int high = numbers.length - 1;

        if(numbers[low] < numbers[high]){
            return numbers[low];
        }

        while (low <= high){

            int mid = low + (high - low)/2;

            if(numbers[mid] == numbers[high]){
                high--;
            } else if(numbers[mid] < numbers[high]){
                high = mid;
            } else if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {

    }
}
