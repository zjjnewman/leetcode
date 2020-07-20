package leetcode.math;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题 https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class JZ10er {
    public int numWays(int n) {

        if(n == 0 || n == 1){
            return 1;
        }




        int i = n + 1;

        int a1 = 0;
        int a2 = 1;
        int a3 = 0;

        while (i >= 2){
            a3 = (int)((a1 + a2) %(1e9 + 7));

            a1 = a2;
            a2 = a3;
            i--;
        }

        return a3;
    }

    public static void main(String[] args) {
        JZ10er l = new JZ10er();
        System.out.println(l.numWays(55));
    }
}
