package leetcode.math;

/**
 * 剑指 Offer 14- II. 剪绳子 II https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 这题涉及到了循环求余、快速幂求余
 */
public class JZ14er {
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
        int idx = tmp / 3;

        double result = 1;

        if(tmp % 3 == 0){
            while (idx > 0){
                result = ((3 * result) % (1e9 + 7));
                idx--;
            }

            //return (int) (Math.pow(3, idx) % (1e9 + 7));
        }else if(tmp % 3 == 2){
            while (idx > 0){
                result = ((3 * result) % (1e9 + 7));
                idx--;
            }
            result = ((2 * result) % (1e9 + 7));
            //return (int) (Math.pow(3, idx) * 2 % (1e9 + 7));
        } else {
            while (idx - 1 > 0){
                result = ((3 * result) % (1e9 + 7));
                idx--;
            }
            result = ((4 * result) % (1e9 + 7));
            //return (int) ((Math.pow(3, idx - 1) * 2 * 2) % (1e9 + 7));
        }
        return (int) result;
    }

    public static void main(String[] args) {
        JZ14er l = new JZ14er();
        System.out.println(l.cuttingRope(120));

    }
}
