package dp;

public class LC0072 {
    public int minDistance(String word1, String word2) {
        /**
         *
         * 第一步找出dp元素的意义
         * 当字符串 word1 的长度为 i，字符串 word2 的长度为 j 时，将 word1 转化为 word2 所使用的最少操作次数为 dp[i] [j]。
         *
         * 一、如果我们 word1[i] 与 word2 [j] 相等，这个时候不需要进行任何操作，显然有 dp[i] [j] = dp[i-1] [j-1]。
         * （别忘了 dp[i] [j] 的含义哈）。
         *      注：因为相等时，不需要调整，所以只需要关注dp[i-1] [j-1]调整了多少步
         *
         * 二、如果我们 word1[i] 与 word2 [j] 不相等，这个时候我们就必须进行调整，而调整的操作有 3 种，我们要选择一种。三种操作
         * 对应的关系试如下（注意字符串与字符的区别）：
         *     （1）、如果把字符 word1[i] 替换成与 word2[j] 相等，则有 dp[i] [j] = dp[i-1] [j-1] + 1;
         *              注：因为经过dp[i-1] [j-1]操作的步数，w1[i-1] w2[j-1]已经相等了，所以对于w1[i] w2[j]只需要操作一步
         *
         *     （2）、如果在字符串 word1末尾插入一个与 word2[j] 相等的字符，则有 dp[i] [j] = dp[i] [j-1] + 1;
         *
         *     （3）、如果把字符 word1[i] 删除，则有 dp[i] [j] = dp[i-1] [j] + 1;
         */

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }

        // 第二步找出动态转移方程
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 增加
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    // 删除
                    dp[i][j] = dp[i - 1][j] + 1;
                    // 更新
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[word1.length() - 1][word2.length() - 1];

        // 第三步找出初始化部分
    }
}
