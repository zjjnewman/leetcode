package qiuzhao.pinduoduo;

import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), t = in.nextInt();
        if (t == 0) {
            System.out.println(0);
            return;
        }
        // 美味值为key, 热量为value构造treemap, 按照key从大到下排序
        TreeMap<Integer, Integer> beautyHotLunchMap= new TreeMap<>(((o1, o2) -> o2-o1));
        TreeMap<Integer, Integer> beautyHotDinnerMap= new TreeMap<>(((o1, o2) -> o2-o1));
        while (n-- > 0) {
            int hot = in.nextInt();
            int beauty = in.nextInt();
            if (beautyHotLunchMap.containsKey(beauty) && beautyHotLunchMap.get(beauty) <= hot) {
                continue;
            }
            beautyHotLunchMap.put(beauty, hot);
        }
        while (m-- > 0) {
            int hot = in.nextInt();
            int beauty = in.nextInt();
            if (beautyHotDinnerMap.containsKey(beauty) && beautyHotDinnerMap.get(beauty) <= hot) {
                continue;
            }
            beautyHotDinnerMap.put(beauty, hot);
        }
        // 构造数组 beautyHotLunch[i][0]表示此时的美味值. 美味值从后到前递减. beautyHotLunch[i][1] 表示获取该美味值的最少热量
        // 最少热量是重点, 体现在 minHot 从后往前的更新上
        int[][] beautyHotLunchArr = new int[beautyHotLunchMap.size()][2];
        int i = beautyHotLunchArr.length-1;
        int minHot = Integer.MAX_VALUE; // 当前最少热量
        for (int beauty: beautyHotLunchMap.keySet()) {
            minHot = Math.min(beautyHotLunchMap.get(beauty), minHot);
            beautyHotLunchArr[i] = new int[]{beauty, minHot};
            i--;
        }

        int[][] beautyHotDinnerArr = new int[beautyHotDinnerMap.size()][2];
        i = beautyHotDinnerArr.length-1;
        minHot = Integer.MAX_VALUE;
        for (int beauty: beautyHotDinnerMap.keySet()) {
            minHot = Math.min(beautyHotDinnerMap.get(beauty), minHot);
            beautyHotDinnerArr[i] = new int[]{beauty, minHot};
            i--;
        }

        // 如果两餐的最大热量不够, 返回-1
        if (beautyHotLunchArr[beautyHotLunchArr.length-1][0] + beautyHotDinnerArr[beautyHotDinnerArr.length-1][0] < t) {
            System.out.println(-1);
            return;
        }

        int ans = Integer.MAX_VALUE;
        // 如果第一餐的最大美味值超过t, 则判断一下只吃第一餐满足要求的最少热量
        if (beautyHotLunchArr[beautyHotLunchArr.length-1][0] >= t) {
            i = binarySearch_me(beautyHotLunchArr, t); // 自定义的二分查找
            ans = Math.min(ans, beautyHotLunchArr[i][1]);
        }
        // 如果第二餐的最大美味值超过t, 则判断一下只吃第二餐满足要求的最少热量
        if (beautyHotDinnerArr[beautyHotDinnerArr.length-1][0] >= t) {
            i = binarySearch_me(beautyHotDinnerArr, t);
            ans = Math.min(ans, beautyHotDinnerArr[i][1]);
        }

        for (i = 0; i < beautyHotLunchArr.length; i++) {
            int beautyLunch = beautyHotLunchArr[i][0];
            if (beautyLunch >= t) { // 中餐足够满足热量时可以退出了
                break;
            }
            int j = binarySearch_me(beautyHotDinnerArr, t - beautyLunch);
            // 更新热量值
            ans = Math.min(ans, beautyHotLunchArr[i][1] + beautyHotDinnerArr[j][1]);
        }
        System.out.println(ans);
    }

    // 数组中满足美味值的最少热量摄入的下标
    public static int binarySearch_me(int[][] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid][0];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal >= key) {
                high = mid;
            }
        }
        return low;
    }
}
