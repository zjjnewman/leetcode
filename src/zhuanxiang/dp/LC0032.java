package zhuanxiang.dp;

/**
 * 32. 最长有效括号 https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 */
public class LC0032 {
    public int longestValidParentheses(String s) {
        /**
         * 1.zhuanxiang.dp[i] 为前i个字符有效子括号的有效长度
         *
         *
         * 2.状态转移：左i 右j显然 j >= i，所以只用到对角线上面的空格，
         *       若
         */
        int len = s.length();
        char[] chars = s.toCharArray();

        int[] dp = new int[len];
        int max = 0;
        for(int i = 1; i < len; i++){
            if(chars[i] == ')'){
                if(chars[i - 1] == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if(i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '('){
                    if(i - dp[i - 1] - 2 >= 0){
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
