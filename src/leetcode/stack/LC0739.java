package leetcode.stack;

import java.util.LinkedList;

/**
 * 739. 每日温度 https://leetcode-cn.com/problems/daily-temperatures/ https://www.bilibili.com/video/BV1SK411V7Lq?p=2
 */
public class LC0739 {

    public int[] dailyTemperatures(int[] T) {
        if(T.length == 0 || T.length == 1){
            return new int[]{0};
        }
        int[] waitDays = new int[T.length];

        LinkedList<Integer> stack = new LinkedList<>();

        int i = 0;
        stack.push(i);
        i++;

        while (i < T.length){
            if(stack.isEmpty()){
                stack.push(i);
            }
            @SuppressWarnings("ConstantConditions")
            int top = stack.peek();
            if(T[top] < T[i]){
                waitDays[top] = i - top;
                stack.pop();
//                stack.push(i);
                continue;
            } else if (T[top] >= T[i]){
                stack.push(i);
            }
            i++;
        }

        while (!stack.isEmpty()){
            waitDays[stack.pop()] = 0;
        }

        return waitDays;
    }



    // 非栈做法 	1481ms 太慢了
    public int[] dailyTemperatures2(int[] T) {
        if(T.length == 0 || T.length == 1){
            return new int[]{0};
        }

        int[] waitCnts = new int[T.length];
        for (int i = 0; i < waitCnts.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < T.length; j++) {
                cnt++;
                if(T[j] > T[i]){
                    break;
                }
                if(j == T.length - 1){
                    cnt = 0;
                }
            }
            waitCnts[i] = cnt;
        }
        return waitCnts;
    }
}
