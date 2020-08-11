package chapter1;

/**
 * 作者：牛妹
 * 链接：https://www.nowcoder.com/discuss/29350?type=all&order=time&pos=&page=1&channel=666&source_id=search_all
 * 来源：牛客网
 *
 * 题目三：
 *
 * 有一排正数，玩家A和玩家B都可以看到。
 * 每位玩家在拿走数字的时候，都只能从最左和最右的数中选择一个。
 * 玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
 * 两人都力争自己拿到的数的总和比对方多。请返回最后获胜者的分数。
 *
 * 例如：
 * 5,2,3,4
 * 玩家A先拿，当前他只能拿走5或者4。
 * 如果玩家A拿走5，那么剩下2，3，4。轮到玩家B，此时玩家B可以选择2或4中的一个，…
 * 如果玩家A拿走4，那么剩下5，2，3。轮到玩家B，此时玩家B可以选择5或3中的一个，…
 */
public class three {
    /**
     * 第一种解法
     */
    public int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }
    // 先发
    public int f(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j),
                arr[j] + s(arr, i, j - 1));
    }
    // 后发
    public int s(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        return Math.min(f(arr,i + 1, j), f(arr, i, j - 1));
    }

    /**
     * 第二种
     *                   f(i, j)
     *                 /        \
     *                /          \
     *               /            \
     *          f(i-1, j)        f(i, j-1)
     *          /    \              /    \
     *         /      \            /      \
     *        /        \          /        \
     * f(i-2, j)  f(i-1, j-1) f(i-1, j-1) f(i, j-2)
     *
     */


}
