package zhuanxiang.dp;

public class DPGuide {

    //1.如果是《0-1背包》，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；
    public static int dp0_1(int[] nums, int target) {
        int[] dp = new int[nums.length+1];
        for(int i=0; i < nums.length; i++){
            for (int j = target; j >= nums[i] ; j--) {

            }
        }
        return dp[nums.length];
    }
    //2.如果是《完全背包》，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。
    public static int dpCompete(int[] nums, int target) {
        int[] dp = new int[nums.length+1];
        for(int i=0; i < nums.length; i++){
            for (int j = 1; j <= target ; j++) {

            }
        }
        return dp[nums.length];
    }
    //上面两种状况参考下面 完全版的代码
    //3.如果《组合问题》需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。
    public static int combinationSum4(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){
                    dp[i] = dp[i] + dp[i-nums[j]];
                }
            }
        }
        System.out.println(dp[2]);
        return dp[target];
    }

    public static void main(String[] args) {
        combinationSum4(new int[]{1, 3, 4}, 5);
    }
/*

1.组合问题公式
dp[i] += dp[i-num]

2.True、False问题公式
dp[i] = dp[i] or dp[i-num]

3.最大最小问题公式
dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)

背包问题技巧：
1.如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target在内循环，且内循环倒序；

for num in nums:
    for i in range(target, nums-1, -1):

2.如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。

for num in nums:
    for i in range(nums, target+1):

3.如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。

for i in range(1, target+1):
    for num in nums:


作者：Jackie1995
链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
}
