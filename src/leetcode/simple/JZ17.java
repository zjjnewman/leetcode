package leetcode.simple;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数 https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class JZ17 {

    public int[] printNumbers(int n) {
        if(n == 0){
            return new int[]{};
        }

        int max = 1;

        while (n > 0){
            max = max * 10;
            n--;
        }
        max = max - 1;

        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i+1;
        }

        return arr;
    }

}
