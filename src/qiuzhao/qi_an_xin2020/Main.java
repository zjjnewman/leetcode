package qiuzhao.qi_an_xin2020;

import java.util.*;

public class Main {

    /**
     * 1.老板发奖金
     *
     * 给出一个正整数，求出组成这个正整数，所有的组合（有排序区别）
     */
    List<Integer> arr = new ArrayList<>();
    int cnt = 0;
    public int CalulateMethodCount (int num_money) {

        CalulateMethodCountHelper(num_money, 1);

        return cnt;
    }



    public void CalulateMethodCountHelper(int n, int start){
        if(n < 0){
            return;
        } else if(n == 0){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer i : arr) {
                if(map.containsKey(i)){
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            int a = 1;
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                int b = entry.getValue();
                a = a * f(b);
            }

            cnt = cnt + f(arr.size()) / a;
        } else {

            for (int i = start; i <= n; i++) {
                arr.add(i);
                CalulateMethodCountHelper(n - i, i);
                arr.remove((Integer)i);
            }
        }
    }

    // n的阶乘
    public int f(int n){
        if(n == 1){
            return 1;
        } else {
            return n * f(n - 1);
        }
    }





    public static void main(String[] args) {

        Main t = new Main();
        System.out.println(t.CalulateMethodCount(6));
    }
}