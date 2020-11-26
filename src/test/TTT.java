package test;

import java.util.*;

public class TTT {
    static public String findMaxSubstr (String str) {
        // write code here
        String ret = "";
        int max = Integer.MIN_VALUE;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                left = Math.max(map.get(str.charAt(i))+1, left);
            }
            map.put(str.charAt(i), i);
            if(max < i-left+1){
                ret = str.substring(left, i+1);
            }
            max = Math.max(max, i-left+1);
        }
        return ret;

    }

    public static void main(String[] args) {
        System.out.println(findMaxSubstr("abcdbcdcbabcdefggcwa"));
    }
}
