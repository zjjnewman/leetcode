package qiuzhao.oukeyunlian;

public class T1 {
    public static int search (int[] nums, int target) {
        if(nums==null|| nums.length ==0){
            return -1;
        }
        if(target > nums[nums.length-1] || target < nums[0]){
            return -1;
        }
        int i = 0;
        int j = nums.length;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                j = mid -1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
