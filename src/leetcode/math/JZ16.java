package leetcode.math;

/**
 * 剑指 Offer 16. 数值的整数次方 https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 *
 * float ：
 *      符号位：1
 *      阶码：8    移码表示
 *      尾数：23   原码表示    有一个隐藏位
 * double 所占位数
 *      符号位：1
 *      阶码：11   移码表示
 *      尾数：52   原码表示    有一个隐藏位
 *
 * double 真值公式：
 *      e表示阶码
 *      m表示尾数
 *      s表示符号位数值
 *            (-1) ^ s * 1.m * 2 ^ (e - 1023)
 */
public class JZ16 {

    // 快速幂
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }

        if(x == 1 || n == 0){
            return 1;
        }

        //先写出都是正数的情况
        // 指数赋值，用long是因为 int的取值范围是[-2^31, 2^31-1]，若把-2^31转成正，会越界
        long e = n;

        // 底数赋值
        double w = x;
        // 若指数是负值，转换为正值
        if(e < 0){
            e = -e;
            w = 1/w;
        }

        // 结果赋值
        double res = 1;

        while (e > 0){

            //求指数位
            int b = (int) (e & 1);
            //若指数位b=0 则res不变，因为这一项的0次方是1
            if(b != 0){
                res = res * w;
            }
            // 下一项的底数
            w = w * w;
            // 下一项的指数位
            e = e >>> 1;
        }

        return res;

    }



    public double myPow1(double x, int n) {
        //x ^ n

        if(x == 0){
            return 0;
        }

        if(n == 0 || x == 1){
            return 1;
        }

        long e = n;
        double w = x;

        if(e < 0){
            x = 1 / x;
            w = x;
            e = -e;
        }

        while (e > 1){
            e--;
            x = x * w;
        }

        return x;
    }

    public static void main(String[] args) {
        JZ16 l = new JZ16();
        System.out.println(l.myPow(2, -2));

    }
}
