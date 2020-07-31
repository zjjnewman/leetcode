package leetcode;

/**
 * 剑指 Offer 19. 正则表达式匹配 https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 *
 *
 * ———————————————————留坑—————————————————————
 */
public class JZ19 {

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
     *
     * '.'不能表示空字符
     * '*'前面的一个字符 可以出现0次 n次
     *
     *
     * 思路：优先考虑str的长度和 模式规则字符串长度是否匹配（去除 *之后的长度），
     * 若匹配，则
     * 若不匹配：
     *      若str长 大于 pattern，扩充 * 前的字符，若 * 有多个，进一步处理
     *      若str长 小于 pattern，把型号前的字符 和星号删除，若长度相符，尝试匹配，若长度不符，直接返回 false
     */

    public boolean isMatch1(String str, String pattern) {

        /**
         * 如果在当前首字符发生不匹配:
         *                  1.不匹配的字符是'.'按匹配处理。
         *                  2.不匹配的字符 不是'*'，不是'.'
         *                              查看pattern下一个字符是否为*，
         *                                      若是继续下一轮比较
         *                                      若不是返回false
         *                  3.不匹配的字符是 *，查看str前一个字符，和这个字符是否相等
         *                              若不相等
         */
        int lenS = str.length();
        int lenP = pattern.length();

        // 两个都为空，必匹配
        if(lenS == 0 && lenP == 0){
            return true;
        }

        // 字符串不空，正则为空 必不匹配
        if(lenP == 0 && lenS != 0){
            return false;
        }
        // 如果字符串为空 其中一类返回true
        if(lenS == 0 && lenP != 0){
            if(lenP == 2 && pattern.charAt(lenP - 1) == '*'){
                return true;
            }
        }

        /**
         * 正则非空，字符串也非空，分为几种情况，从最后开始匹配
         *      1. 若pattern最后字符 是普通字符
         *                  相等，继续下一次判断 f(n-1, m - 1)
         *                  不相等 返回false
         *
         *      2. 若pattern最后字符是正则字符
         *                  若为'.'，相等，继续下一次判断 f(n-1, m - 1)
         *                  若为'*'，查看
         *
         *      1. 若str pattern字符串最后的字符相等 直接下一次判断 f(n-1, m - 1)
         *
         *      2. 若str pattern字符串最后的字符不相等，分为几种状况
         *              若pattern为".*"直接返回true
         *              若不是：
         *                  若pattern最后的字符是'.'继续 f(n-1, m - 1)
         *                  若pattern的最后字符不是 * . 返回false
         *                  若pattern最后的字符是'*'，查看*前一个字符
         *                               若是'.'直接继续 f(n, m - 2)
         *                               若是普通字符，查看 pattern前一个字符 和 str当前字符是否相等
         *                                      若不相等 返回 false
         *                                      若相等，直接找出 str 所有与该字符 相等且连续的，直到不相等的str idx，继续下次比较 f(idx, n - 2)
         *
         *
         * "aab"
         * "c*a*b"
         * "aa"
         * "aa*"
         */

        if(str.charAt(lenS - 1) == pattern.charAt(lenP - 1)){
            return isMatch(str.substring(0, lenS - 1), pattern.substring(0, lenP - 1));
        } else {
            if(pattern.equals(".*")){
                return true;
            } else {
                if (pattern.charAt(lenP - 1) == '.'){
                    return isMatch(str.substring(0, lenS - 1), pattern.substring(0, lenP - 1));
                }

                if(pattern.charAt(lenP - 1) != '*'){ //若pattern的最后字符不是 * . 返回false
                    return false;

                } else { //若pattern最后的字符是'*'，查看*前一个字符

                    // 这里怎么判断 pattern 存在 前一个字符
                    if(pattern.charAt(lenP - 2) == '.'){//若是'.'直接继续 f(n, m - 2)
                        return isMatch(str.substring(0, lenS), pattern.substring(0, lenP - 2));

                    } else {//若是普通字符，查看 pattern前一个字符 和 str当前字符是否相等

                        if(pattern.charAt(lenP - 2) != str.charAt(lenS - 1)){//若不相等 返回 false
                            return false;
                        } else {//若相等，直接找出 str 所有与该字符 相等且连续的，直到不相等的str idx，继续下次比较 f(idx, n - 2)

                            char tmp = str.charAt(lenS - 1);
                            int i = lenS - 1;
                            while (i >= 0 && str.charAt(i) == tmp){
                                i--;
                            }



                            if(i < 0){
                                if(lenP > 2){
                                    return isMatch(str.substring(0, 1), pattern.substring(0, lenP - 2));
                                } else {
                                    return true;
                                }
                            } else {
                                return isMatch(str.substring(0, i), pattern.substring(0, lenP - 2));
                            }
                        }
                    }
                }
            }
        }
    }



    // 题解写法
    public boolean isMatch(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (pattern.charAt(j - 1) != '*') {
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }



}
