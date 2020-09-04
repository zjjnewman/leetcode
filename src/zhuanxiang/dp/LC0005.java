package zhuanxiang.dp;

/**
 * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LC0005 {
    /**
     * 1.状态的定义，求什么就定义什么状态，这里求的是 是否为回文子串，可以定义dp[i][j]存储的是[si, sj]区间内是不是回文子串，如果是为true
     *
     * 2.状态的转移，[si, sj]是回文子串的前提是[s(i+1), s(j-1)]也是回文子串，同时si == si 为true，即
     *      zhuanxiang.dp[i][j] = (si == sj) && zhuanxiang.dp[i+1][j-1]
     *
     *
     * 3.考虑边界和初始化问题：i j描述的是子串的左右边界字符，所以肯定满足 i <= j，即对角线以上的区域
     *      0. 若i == j 空字符，肯定满足
     *      1. 若i == j 只有一个字符，肯定满足
     *      2. 若i < j && (j - i + 1 <= 2)=>j - i <= 1，有两个字符，只需要判断 si == sj
     *      3. 若i < j && (j - i + 1 <= 3)=>j - i <= 2，有三个字符，只需要判断 si == sj
     *      以上 2 3可以归为一种状况，
     *
     *      4. 其他状况为一般状况，可以由状态方程得到
     *
     */

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();

        // 初始化 i==j
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 初始化 j - i <= 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i < j && j - i <= 2){
                    dp[i][j] = chars[i] == chars[j];
                }
            }
        }

        // 开始状态转移
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(j - i > 2){
                    dp[i][j] = (chars[i] == chars[j]) && dp[i+1][j-1];
                }
            }
        }

        // i最小，j最大的时候为最长回文子串，所以让i从0 开始，j从最大开始 找到的第一个true就是最长的回文子串-----错误，没有考虑i起点不一致的状况
        int l = n;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i <= j && dp[i][j]){
                    if(j - i > r - l){
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r+1);
    }

    /**
     * 输入：
     *      "ababababa"
     * 输出：
     *      "ababa"
     * 预期：
     *      "ababababa"
     */
    public static void main(String[] args) {
        String s = "ababababa";
//        boolean[][] booleans = longestPalindrome(s);
//        for (boolean[] aBoolean : booleans) {
//            System.out.println(Arrays.toString(aBoolean));
//            System.out.println("");
//        }
    }

}
