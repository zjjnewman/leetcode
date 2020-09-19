package zhuanxiang.dp;

/**
 * 494. 目标和 https://leetcode-cn.com/problems/target-sum/
 * 
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class LC0494 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i:nums){
            sum += i;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if ((sum+S)%2==1){
            return 0;
        }
        // 目标和不可能大于总和
        if (S>sum){
            return 0;
        }
        int len = (sum+S)/2;
        int[] dp = new int[len+1];
        dp[0] = 1;

//        for (int num:nums){
//            for (int i=len;i>=num;--i){
//                dp[i] += dp[i-num];
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = len; j >= nums[i]; --j) {
//                dp[j] = dp[i] + dp[j-nums[i]];
//            }
//        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }

        return dp[len];
    }

//    作者：inkblack
//    链接：https://leetcode-cn.com/problems/target-sum/solution/huan-yi-xia-jiao-du-ke-yi-zhuan-huan-wei-dian-xing/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
