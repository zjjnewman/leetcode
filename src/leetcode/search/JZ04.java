package leetcode.search;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import leetcode.tree.LeetCode0437;

/**
 * 剑指 Offer 04. 二维数组中的查找 https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class JZ04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int toLeftIdx = matrix[0].length - 1;
        int toDownIdx = 0;

        while (toDownIdx < matrix.length && toLeftIdx >= 0) {

            if (matrix[toDownIdx][toLeftIdx] == target) {
                return true;
            }

            if (target < matrix[toDownIdx][toLeftIdx]) {
                toLeftIdx--;
                if(toLeftIdx < 0){
                    return false;
                }
            }
            if (target > matrix[toDownIdx][toLeftIdx]) {
                toDownIdx++;
            }
        }
        return false;
    }






    // 这块想错了，想成他们是对称的矩阵了
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int high = matrix.length;
        int low = 0;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(matrix[mid][mid] == target){
                return true;
            }

            if(target < matrix[mid][mid]){
                for (int i = mid - 1; i >= 0 ; i--) {
                    if(matrix[mid][i] == target){
                        return true;
                    }

                    if(matrix[i][mid] == target){
                        return true;
                    }
                }
                high = mid - 1;
            } else {
                for (int i = mid + 1; i < matrix.length ; i++) {
                    if(matrix[mid][i] == target){
                        return true;
                    }

                    if(matrix[i][mid] == target){
                        return true;
                    }
                }
                low = mid + 1;
            }
        }

        return false;
    }

    public int binarySearch(int[] nums, int target){

        int low = 0;
        int high = nums.length;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-5}};
        int toLeftIdx = matrix[0].length - 1;
        int toDownIdx = 0;

        System.out.println();

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

    }
}
