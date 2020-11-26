package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Te {
    public static void dfs(int[]nums,int post, int target, List<List<Integer>> ret, List<Integer> combine){
        if(target == 0 && post < nums.length){
            ret.add(new ArrayList<>(combine));
            return;
        }
        if(target < 0 || post>=nums.length){
            return;
        }
        combine.add(nums[post]);
        dfs(nums, post+1, target-nums[post], ret, combine);
        combine.remove(combine.size()-1);
        dfs(nums, post+1, target, ret, combine);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        s1 = s1.substring(1, s1.length()-1);
        s2 = s2.substring(1, s2.length()-1);
        String[] ss1 = s1.split(",");
        int[] nums = new int[ss1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss1[i]);
        }
        Arrays.sort(nums);
        int target = Integer.parseInt(s2);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(nums, 0, target, ret, combine);
        for (List<Integer> list : ret) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
                sb.append(",");
            }
            System.out.println( sb.substring(0, sb.length()-1)+"\r");
        }
    }
}
