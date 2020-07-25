package leetcode.graph;

import sun.misc.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围 https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 */
public class JZ13 {
    /**
     * 贪心，每次机器人移动到坐标数位之和最小的格子
     * 但是考虑到每次机器人只能移动一格，也就意味着，每次高位固定，低位只增加1，所以数位之和每次移动增加1；
     * 当产生进位时，例如 19 + 1 = 20  数位和变成 10 -> 2
     *                  9 + 1 = 10  数位和变成  9 -> 1
     *                  可以推断出，每次其中一个坐标进位，就会使原来的数位和 -8， 因为高位 +1 低位 -9，共 -8。
     * 由上面分析，可以推出：
     *      若其中一个坐标轴超过10，或10的倍数
     *          在数位和不超过k的情况下，尽可能的使其中一个坐标进位，即朝着超过 10 坐标方向前进，不断累加这个方向数位和，直到进位。
     *      若没有坐标轴超过10，那么数位和
     *
     * 以上考虑只增加的状况，还有坐标减小的状况
     *
     */

    int max = 0;
    // 求数位和
    public int digitSum(int row, int column){
        int sumR = 0;
        int sumC = 0;
        while (row != 0){
            sumR = row % 10 + sumR;
            row = row / 10;
        }
        while (column != 0){
            sumC = column % 10 + sumC;
            column = column / 10;
        }
        return sumR + sumC;
    }

    public int movingCount(int m, int n, int k) throws InterruptedException {

        if(m == 0 || n == 0){
            return 0;
        }

        boolean[][] visited = new boolean[m][n];

        dfs(visited, 0, 0, k);
        return max;

    }


    public void bfs(boolean[][] visited, int row, int column, int k) throws InterruptedException {
        Queue<int[]> queue = new Queue<int[]>();
        queue.enqueue(new int[]{row, column});
        while (!queue.isEmpty()){
            int[] coordinate = queue.dequeue();
            if(coordinate[0] >= visited.length || coordinate[1] >= visited[0].length ||
                    digitSum(coordinate[0], coordinate[1]) > k || visited[coordinate[0]][coordinate[1]]){
                continue;
            }
            max++;
            visited[coordinate[0]][coordinate[1]] = true;
            queue.enqueue(new int[]{coordinate[0] + 1, coordinate[1]});
            queue.enqueue(new int[]{coordinate[0], coordinate[1] + 1});
        }
    }


    public void dfs(boolean[][] visited, int row, int column, int k){
        if(row >= visited.length || column >= visited[0].length || digitSum(row, column) > k || visited[row][column]){
            return;
        }
        max++;
        visited[row][column] = true;
        //下
        dfs(visited, row + 1, column, k);
        //右
        dfs(visited, row, column + 1, k);
    }

    public int dfs1(boolean[][] visited, int row, int column, int k) {
        if(row >= visited.length || column >= visited[0].length || k < digitSum(row, column) || visited[row][column]){
            return 0;
        }
        visited[row][column] = true;
        return 1 + dfs1(visited, row + 1, column, k) +
                   dfs1(visited, row, column + 1, k);
    }


    public static void main(String[] args) throws InterruptedException {
        JZ13 l = new JZ13();
        System.out.println(l.movingCount(38,15,9));
        System.out.println(l.digitSum(11, 20));


    }

}
