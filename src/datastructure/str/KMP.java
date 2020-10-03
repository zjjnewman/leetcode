package datastructure.str;

import java.util.Arrays;

public class KMP {
    static public int[] kmpNext(String pattern){
        int i = 0,j = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    static public boolean kmpSearch(String s, String pattern){
        int[] next = kmpNext(pattern);
        int i = 0, j = 0;
        while (i < s.length()){
            if(j == pattern.length() - 1 && s.charAt(i) == pattern.charAt(j)){
                // 匹配的位置是：i-j
                System.out.println("匹配到的位置是：" + (i-j));
                // 如果要匹配多个使用下面的语句
                j = next[j];
//                return true;
            }
            if(s.charAt(i) == pattern.charAt(j)){
                i++; j++;
            } else {
                j = next[j];
                if(j==-1){
                    i++; j++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ababcabaaababcabaa";
        String s = "dafsababcabaa";
        String pattern = "ababcabaa";
        String pat1="abab";
        System.out.println(Arrays.toString(kmpNext(pattern)));
        System.out.println(kmpSearch("abc", "bc"));
    }
}
