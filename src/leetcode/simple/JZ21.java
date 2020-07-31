package leetcode.simple;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class JZ21 {


    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            while (i < nums.length && nums[i] % 2 != 0){
                i++;
            }

            while (j >= 0 && nums[j] % 2 == 0){
                j--;
            }


            if(i < j && i < nums.length && j >= 0){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return nums;
    }

    public int[] exchange1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0){
                continue;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] %2 == 0){
                j++;
            }
            if(j == nums.length){
                break;
            }
            swap(nums, i, j);
        }

        return nums;
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }


    public static void main(String[] args) {

        JZ21 l = new JZ21();
        l.exchange(new int[]{1,2,3,4,7,6,68,23});
    }
}
