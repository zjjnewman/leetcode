import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import datastructure.tree.TreeNode;
import datastructure.tree.TreeUtils;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Test {


    public static double methoed(int n){
        double dInit = 1000.0;
        int cnt = 0;
        double dR = 0;
        while (cnt != n){
            dR = dR + dInit + dInit/2;
            dInit = dInit/2;
            cnt++;
        }
        return dR;
    }



    public static boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int a=0;
        return (a = f(nums, 0, nums.length - 1)) > sum - a;
    }

    //先发者
    public static int f(int[] nums, int i, int j){
        if(i == j){
            return nums[i];
        }
        return Math.max(nums[i] + s(nums, i+1, j), nums[j] + s(nums, i, j - 1));
    }

    //后发者
    public static int s(int[] nums, int i, int j){
        if(i==j){
            return 0;
        }
        return Math.min(f(nums, i+1,j),f(nums, i,j-1));
    }

    public static void main(String[] args){
    }





}
