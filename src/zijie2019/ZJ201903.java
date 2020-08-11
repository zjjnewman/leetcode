package zijie2019;

import java.util.*;

public class ZJ201903 {
    /**
     * https://www.nowcoder.com/test/question/analytic?tid=35258752
     *
     * 由 1~9 组成36个数，4个同样的数字为一组
     *
     * 赢了时满足如下条件：
     *      共14个数
     *      有 1个对子
     *      剩下12个数中 要么全部是 3连， 要么全部是 3同
     *
     *
     *      1. 1对 4个顺子
     *
     *      2. 1对 4个刻子
     *
     *      缺的这个数 可能组成
     *             1. 对子： 剩下的牌组成
     *                  4个顺子    或
     *                  4个刻子
     *
     *             2. 顺子
     *                  3个顺子，1个对子
     *
     *             3. 刻子
     *                  3个刻子，1个对子
     *
     *     由于数字是 1~9 那么 由鸽巢原理：13张牌里 必定有：
     *          至少 2个重复牌：1 2 3 4 5 6 7 8 9  1 1 1 2
     *          至多 4个重复牌：1 2 3 4 5 6 7 8 9  1 2 3 4
     *
     */


    /**
     * 赢的状况有：
     *      1. 1个对子 4个顺子
     *              11 123 123 234 234  1111 2222 3333 44
     *              11 123 234 234 234  111  2222 3333 444
     *              11 234 234 234 234  11   2222 2222 4444
     *
     *              11 234 567 789 234  11 22 33 44 5  6 7  8 9
     *              11 234 567 789 345  11 2  33 44 55 6  77 8 9
     *              11 234 567 789 456  11 2  3  44 55 66 77 8 9
     *              11 234 567 789 567
     *              11 234 567 789 678
     *              11 234 567 789 789
     *
     *
     *      2. 1个对子 4个刻子
     *              11 222 333 444 555
     */
    public boolean isWin(int[] nums){
        Arrays.sort(nums);

        return true;
    }

    public void copy(int[] source, int[] target, int fLow, int fHigh, int toLow, int toHigh){

    }



    public static void main(String[] args) {

        HashSet<Integer>  set = new HashSet(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);}};
        set.forEach(System.out::println);

    }




}
