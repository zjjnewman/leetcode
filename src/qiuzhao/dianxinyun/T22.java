package qiuzhao.dianxinyun;

import java.util.*;

public class T22 {

    static public boolean isContinuous(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            if(! (arr.get(i)+1 == arr.get(i+1))){
                return false;
            }
        }
        return true;
    }

    static void dfs(int[] arr, int post, Set<Integer> combine, Set<Set<Integer>> ret){
        if(post >= arr.length){
            return;
        }
        if(combine.size()>=5){
            ret.add(new HashSet<>(combine));
        }
        combine.add(arr[post]);
        dfs(arr, post+1, combine, ret);
        combine.remove(combine.size()-1);
        dfs(arr, post+1, combine, ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
        }
        Set<Integer> combine = new HashSet<>();
        Set<Set<Integer>> ret = new HashSet<>();
        dfs(arr, 0, combine, ret);
        System.out.println();
        for (Set<Integer> i : ret) {
            System.out.println(i);
        }
    }
}

/*
234345567
 */
