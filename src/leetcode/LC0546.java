package leetcode;


import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 546. 移除盒子 https://leetcode-cn.com/problems/remove-boxes/
 */
public class LC0546 {

    /**
     * 每一轮都要移除，当前状态下 连续出现次数最多的项；
     *      方法的功能是，传进数数组，返回出移除的数量
     * 重复上面操作，直到 全部处理完。
     */
    //{1,3,2,2,2,3,4,3,1};
    public int removeBoxes(int[] boxes) {
        int cnt = 0;
        int len = boxes.length;
        while (len > 0){
            int k = helper(boxes, len);
            cnt = cnt + k * k;
            len = len - k;
        }
        return cnt;
    }





    // 返回移除的数量
    public int helper(int[] boxes, int length){
        // 记录最多 连续盒子开始下标
        int low = 0;
        // 记录最多 连续盒子结束下标
        int high = length - 1;
        int cnt=0;
        for (int i = 0; i < length - 1; i++) {
            // 记录连续盒子开始下标
            int lowTmp = i;
            // 记录连续盒子结束下标
            int highTmp = i;

            // 这个循环的目的是找到连续的盒子，
            while (boxes[i] == boxes[i + 1]){
                highTmp++;
                if(i < length - 2){
                    i++;
                } else {
                    break;
                }
            }

            // 下面这块代码，找出 不连续的 同颜色 共有多少
            int cntTmp=0;
            for (int j = i + 1; j < length; j++) {
                if(boxes[j] == boxes[highTmp]){
                    cntTmp++;
                }
            }
            for (int j = 0; j < lowTmp; j++) {
                if(boxes[j] == boxes[highTmp]){
                    cntTmp++;
                }
            }

//
//            for (int j = high + 1; j < length; j++) {
//                if(boxes[j] == boxes[high]){
//                    cnt++;
//                }
//            }
//            for (int j = 0; j < low; j++) {
//                if(boxes[j] == boxes[high]){
//                    cnt++;
//                }
//            }

            // 找到连续的盒子后，查看刚找到的连续盒子，和之前的连续盒子数量，留下较多的连续盒子的下标
//            if(0 == cnt){
            if(highTmp - lowTmp < high - low && cntTmp == 0){
                high = highTmp;
                low = lowTmp;
                cnt = cntTmp;
            }
            else if(highTmp - lowTmp + cntTmp > high - low +cnt){
                high = highTmp;
                low = lowTmp;
                cnt = cntTmp;
            }
        }
        // 经过上面的过程，找到了这一轮要移除的下标，为了节省空间，在原数组做移除操作
        removeK(boxes, length, low, high);
        return high - low + 1;
    }

    public void removeK(int[] boxes, int length, int low, int high){
        for (int i = high + 1; i < length ; i++) {
            boxes[low] = boxes[i];
            low++;
        }
    }

    public static void main(String[] args) {
        LC0546 t = new LC0546();

        int[] boxes = new int[]{1,3,2,2,2,3,4,3,1};
//        int[] boxes = new int[]{1,1,1};
        System.out.println(t.removeBoxes(boxes));
//        System.out.println(t.helper(boxes, boxes.length));
//        t.removeK(boxes, boxes.length, 2, 4);
        System.out.println(Arrays.toString(boxes));
    }
}
