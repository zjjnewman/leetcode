package qiuzhao.dianxinyun;

import java.util.Scanner;

public class T11 {
    static public void twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(nums[i]+" "+nums[j]);
                    return;
                }
            }
        }
        System.out.println("Not found");;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        twoSum(nums, target);
    }
}
