package leetcode.math;


/**
 * 剑指 Offer 10- I. 斐波那契数列 https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class JZ10yi {

    public int fib(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }
        int a1 = 0;
        int a2 = 1;
        int a3 = -1;

        int i = n;

        while (i >= 2){
            a3 = (int) ((a1 + a2) % (1e9 + 7));

            a1 = a2;
            a2 = a3;
            i--;
        }
        return a3;
    }


    // 递归
    public int fib1(int n) {
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fib1(n - 1) + fib1((n - 2));
    }

    public static void main(String[] args) {
        JZ10yi l = new JZ10yi();
        System.out.println(l.fib(8));
//        System.out.println(l.fib1(45));

        System.out.println(1e9);
    }
}
