package zhuanxiang.dp;

/**
 * 486. 预测赢家 https://leetcode-cn.com/problems/predict-the-winner/
 */
public class LC0486 {
    public static boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int sum  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int a=0;
        return (a = f(nums, 0, nums.length - 1)) >= sum - a;
    }

    //先发者
    public static int f(int[] nums, int i, int j){
        if(i == j){
            return nums[i];
        }
        return Math.max(nums[i] + s(nums, i+1, j), nums[j] + s(nums, i, j - 1));
    }

    //后发者
    public static int s(int[] nums, int i, int j){
        if(i==j){
            return 0;
        }
        return Math.min(f(nums, i+1,j), f(nums, i,j-1));
    }


    // 以上为递归过程
    // 以下为动态规划
    public static int win(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j-1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
    }

    public static void main(String[] args) {

    }
}
