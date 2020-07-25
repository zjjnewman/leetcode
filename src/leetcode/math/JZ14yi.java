package leetcode.math;

/**
 * 剑指 Offer 14- I. 剪绳子 https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * 剑指 Offer 14- II. 剪绳子 II https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class JZ14yi {
    /**
     * 分析：初步考虑到，半周长相同的情况下，正方形的面积最大，所以近可能的让绳子平均分割，由于m不确定取多少时最大，所以先枚举找规律
     * 若给定绳子长 10，取
     * m = ：      乘积：
     *      2       5 * 5 = 25
     *      3       4 * 4 * 2 = 32
     *              3 * 3 * 4 = 36
     *              2 * 2 * 6 = 24
     *              1 * 1 * 8 = 8
     *      4       4 * 4 * 1 * 1 = 16
     *              3 * 3 * 2 * 2 = 36
     *              2 * 2 * 2 * 2 * 2 = 32
     *
     * n = 1    1
     * n = 2
     *       m = 2  1
     *
     * n = 3
     *       m = 2  1*2=2
     *       m = 3  1*1*1=1
     *
     * n = 4
     *       m = 2  2*2= 4
     *       m = 3  1*1*2=2
     *       m = 4  1
     *
     * n = 5
     *       m = 2  2*3=6
     *       m = 3  2*2*1=4
     *
     * n = 6
     *       m = 2  3*3=9
     *       m = 3  2*2*2=8
     *              4*1*1=4
     *              3*2*1=6
     *
     */


    public int cuttingRope(int n) {
        if (n <= 1){
            return - 1;
        }

        if(n == 2){
            return 1;
        }

        if(n == 3){
            return 2;
        }

        int tmp = n;
        if(tmp % 3 == 0){
            return (int) Math.pow(3, tmp / 3);
        }
        if(tmp % 3 == 2){
            return (int) (Math.pow(3, tmp / 3) * 2);
        }
        if(tmp % 3 == 1){
            return (int) (Math.pow(3, tmp / 3 - 1) * 2 * 2);
        }

        return - 1;
    }
}
