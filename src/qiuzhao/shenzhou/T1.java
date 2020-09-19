package qiuzhao.shenzhou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        Map<Integer, Integer> list = new HashMap<>();
        String str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
            list.put(Integer.parseInt(strs[i]), i);
        }
        Arrays.sort(nums);
        int index = list.size();
        int cnt = 0;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(nums[i])>list.get(nums[i+1])){
                list.put(nums[i+1], index++);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
