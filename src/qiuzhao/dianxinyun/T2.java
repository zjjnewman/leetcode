package qiuzhao.dianxinyun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    public static String del(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        int min = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            min = Math.min(min, value);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(map.get(c)!=min){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(del(next));
    }
}
