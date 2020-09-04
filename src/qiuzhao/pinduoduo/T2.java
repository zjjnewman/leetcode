package qiuzhao.pinduoduo;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] base = calcuBase(); // 数组 7 7^2 7^3 7^4 7^5
        while (n-- > 0) {
            int[] arr = new int[6]; // 存储色子点数
            int idx_0 = 0; // 点数1 所在的下标
            for (int i = 0; i < 6; i++) {
                arr[i] = in.nextInt();
                if (arr[i] == 1) {
                    idx_0 = i;
                }
            }
            if (idx_0 != 0) { // 1不在首位, 将其转到首位
                change_1(arr, idx_0);
            }
            boolean flag1 = arr[2] < arr[3]; // 第二队是否升序
            boolean flag2 = arr[4] < arr[5]; // 第三队是否升序
            // 状态转换
            if (!flag1 && flag2) {
                changeState(arr, 2);
            } else if (!flag1 && !flag2) {
                changeState(arr, 3);
            } else if (flag1 && !flag2) {
                changeState(arr, 4);
            }
            int key = calcuHashKey(arr, base); // 计算hashMap的key
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        System.out.println(map.size());
        int[] ans = new int[map.size()]; // 每种个数存储到数组里, 进行降序排列
        int i = 0;
        for (int num_map: map.values()) {
            ans[i] = num_map;
            i++;
        }
        Arrays.sort(ans);
        for (i = ans.length-1; i > 0; i--) {
            System.out.print(ans[i] + " ");
        }
        if (ans.length > 0) {
            System.out.print(ans[0]);
        }
    }

    // 构造数组 7 7^2 7^3 7^4 7^5
    public static int[] calcuBase() {
        int[] base = new int[6];
        base[0] = 7;
        for (int i = 1; i < 6; i++) {
            base[i] = 7 * base[i-1];
        }
        return base;
    }

    // 计算hashMap中状态1 B1 A2 B2 A3 B3应该对应的key
    public static int calcuHashKey(int[] arr, int[] base) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += arr[i] * base[i];
        }
        return sum;
    }

    // 将1移到开头
    public static void change_1(int[] arr, int idx_0) {
        if (idx_0 == 1) {
            swap(arr, 0, 1);
            swap(arr, 2, 3);
        } else if (idx_0 % 2 == 1){
            swap(arr, 1, idx_0);
            swap(arr, 0, idx_0-1);
            swap(arr, 0, 1);
        } else {
            swap(arr, 0, idx_0);
            swap(arr, 1, idx_0+1);
            swap(arr, idx_0, idx_0+1);
        }
    }

    // 剩余三种状态转到第一种状态
    public static void changeState(int[] arr, int state) {
        int i = 2, p = 4;
        if (state == 2) {
            swap(arr, i, p);
            swap(arr, i+1, p+1);
            swap(arr, p, p+1);
        } else if (state == 3) {
            swap(arr, i, i+1);
            swap(arr, p, p+1);
        } else if (state == 4) {
            swap(arr, i, p);
            swap(arr, i+1, p+1);
            swap(arr, i, i+1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}