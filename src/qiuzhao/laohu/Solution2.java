package qiuzhao.laohu;

import java.util.*;

public class Solution2 {
    public static ArrayList<ArrayList<Integer>> combinationSum1 (int[] prices, int m) {
        /**
         * 选择的方案恰好为m
         *
         * 设置一个滑动窗口 low high，把price数组升序排序
         */
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        return lists;
    }

    public static void traceBack(int[] prices, int target, int idx, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> cur){

        if(target == 0){
            lists.add(new ArrayList<>(cur));
        } else if(target > 0){
            cur.add(prices[idx]);
            traceBack(prices, target - prices[idx], ++idx, lists, cur);
        } else {
        }
    }



    public ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Arrays.sort(prices);
        helper(lists, new ArrayList<>(), prices, m, 0);
        return lists;
    }
    private void helper(List<ArrayList<Integer>> lists, List<Integer> cur, int[] prices, int target, int start){
        if(target == 0){
            lists.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < prices.length; i++) {
            if(target < prices[i]){
                continue;
            }
            if(i > start && prices[i] == prices[i - 1]){
                continue;
            }
            cur.add(prices[i]);
            helper(lists, cur, prices, target - prices[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum1(new int[]{3, 8, 6}, 14));
    }
}
