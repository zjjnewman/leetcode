package guanglianda;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class ain {

    /**
     *
     * @param nums n个数序列
     * @param m m个x数
     * @param x x数
     * @return
     */
    public int high(int[] nums, int m, int x){

        int tmpIdx = 0;
        boolean isFirst = true;
        int minIdx = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < nums[tmpIdx]){
                    tmpIdx = i;
                }
            }
            if(isFirst){
                minIdx = tmpIdx;
                isFirst = false;
            }
            nums[tmpIdx] = nums[tmpIdx] + x;
        }

        return nums[minIdx];

    }


    public static void main(String[] args) throws IOException {

        /**
         * 可以理解为 有n个数的序列，m个x，把m个x，加到n个数中，
         * 每次 把 1个x加到 ng个数中最小的。直到加完所有x
         */
        // 小草个数
        int n;
        // 魔法药剂的个数
        int m;
        // 每瓶魔法药剂让小草长高的高度
        int x;

        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();

        int[] nums = new int [n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        ain p1 = new ain();
        int high = p1.high(nums, m, x);

        bufferedWriter.write(high+"");
        bufferedWriter.flush();
    }
}
