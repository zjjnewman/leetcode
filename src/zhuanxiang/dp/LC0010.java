package zhuanxiang.dp;


/**
 * 10. 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class LC0010 {

    /**
     * 1.状态的定义，要求的是是否匹配，所以状态就是是否匹配，
     *      zhuanxiang.dp[i][j]表示当 字符串 s 的前i个字符 与 模式串 p 的前j个字符是否匹配
     *
     * 2.状态的转移
     *      1.若p第j个是普通字符
     *          zhuanxiang.dp[i][j] = (si == pj) && zhuanxiang.dp[i-1][j-1]
     *      2.若p第j个是特殊字符
     *          若是 '.'，匹配任意单个字符，所以
     *              zhuanxiang.dp[i][j] = zhuanxiang.dp[i-1][j-1]
     *          若是 '*'，匹配前一个字符的任意次
     *              若p(j-1) != s[i]，直接false；
     *                  zhuanxiang.dp[i][j] = false
     *              若p(j-1) == s[i]
     *                  zhuanxiang.dp[i][j] = zhuanxiang.dp[i-1][j]
     *
     * 3.初始状态寻找
     *      1.当s p都是0，肯定匹配
     *      2.当s是空，p不是空时，分几种状况
     *          1.若 p是字符或者'.'，必不匹配
     *          2.若 p是 x*时必匹配，其他情况不匹配
     *      3.当s不是空，p是空时，肯定不匹配
     */
    public static boolean isMatch(String s, String p) {
        if(p.equals(".*")){
//            return true;
        }

        int sL = s.length();
        int pL = p.length();
        boolean dp[][] = new boolean[sL+1][pL+1];
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        //初始化
        for (int i = 0; i <= sL; i++) {
            for (int j = 0; j <= pL; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i != 0 && j == 0){
                    dp[i][j] = false;
                }else if(i == 0 && j > 0){
                    if(j == 1 && charsP[j-1] == '*'){
                        dp[i][j] = true;
                    }else if(j > 1 && charsP[j-1] == '*'){

                        dp[i][j] = dp[i][j-2];
//                        if(charsP[j - 2] != '\0'){
//                            zhuanxiang.dp[i][j] = zhuanxiang.dp[i][j-2];
//                        } else if(charsP[j - 2] == '\0'){
//                            zhuanxiang.dp[i][j] = zhuanxiang.dp[i-1][j];
//                        }
                    }
                }
            }
        }

        /**
         * 2.状态的转移
         *      1.若p第j个是普通字符
         *          zhuanxiang.dp[i][j] = (si == pj) && zhuanxiang.dp[i-1][j-1]
         *      2.若p第j个是特殊字符
         *          若是 '.'，匹配任意单个字符，所以
         *              zhuanxiang.dp[i][j] = zhuanxiang.dp[i-1][j-1]
         *          若是 '*'，匹配前一个字符的任意次
         *              若p(j-1) != s[i]，直接false；
         *                  zhuanxiang.dp[i][j] = false
         *              若p(j-1) == s[i]
         *                  zhuanxiang.dp[i][j] = zhuanxiang.dp[i-1][j]
         */

        for (int i = 1; i <= sL; i++) {
            for (int j = 1; j <= pL; j++) {
                if(charsP[j-1] != '*' && charsP[j-1] != '.'){
                    dp[i][j] = (charsS[i - 1] == charsP[j - 1]) && dp[i-1][j-1];
                } else {
                    if(charsP[j-1] == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    } else if(charsP[j-1] == '*'){
                        if(charsP[j - 2] != charsS[i - 1]){
                            dp[i][j] = dp[i][j-2];
                        } else if(charsP[j - 2] == charsS[i - 1] || charsP[j-2] =='.'){
                            dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                        }
                    }
                }
            }
        }

        return dp[sL][pL];
    }

    public static void main(String[] args) {
//        boolean[][] aa = isMatch("aaa", "ab*a*c*a");
//        for (boolean[] booleans : aa) {
//            System.out.println(Arrays.toString(booleans));
//            System.out.println("");
//        }
    }
}
