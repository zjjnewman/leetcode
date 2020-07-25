package leetcode.basetypestructure;

/**
 * 剑指 Offer 15. 二进制中1的个数 https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * float 所占位数：
 *      符号位：1
 *      阶码：8
 *      尾数：23 有一个隐藏位
 * double 所占位数
 *      符号位：1
 *      阶码：11
 *      尾数：52 有一个隐藏位
 *
 *
 */
public class JZ15 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if(((n >>> i) & 1) == 1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(n & ((int)(Math.pow(2, 2))));
    }
}
