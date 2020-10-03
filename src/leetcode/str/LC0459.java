package leetcode.str;

import java.util.Arrays;

public class LC0459 {
    static public boolean repeatedSubstringPattern(String s) {
        for(int i = 2; i<= s.length(); i++){
            String p = s.substring(0,i);
            if(kmp(s, p)){
                return true;
            }
        }
        return false;
    }

    static public boolean kmp(String s, String p){
        int[] next = next(p);
        int i = 0, j=0;
        while(i < s.length()){
            if(j == p.length()-1 && s.charAt(i) == p.charAt(j)){
                if(i == s.length()-1){
                    return true;
                }
                System.out.println("匹配在" + (i-j));
                j = next[j];
            }
            if(s.charAt(i)==p.charAt(j)){
                i++;j++;
            }else{
                j=next[j];
                if(j==-1){
                    j++;i++;
                }
            }
        }
        return false;
    }
    static public int[] next(String s){
        int[] next = new int[s.length()];
        int i=0, j=-1;
        next[0] = -1;
        while(i<s.length()-1){
            if(j==-1|| s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                next[i] = j;
            } else{
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        repeatedSubstringPattern("abab");
        String s1 = "ababcabaaababcabaa";
        String s = "dafsababcabaa";
        String pattern = "ababcabaa";
        String pat1="abab";
        System.out.println(Arrays.toString(next("a")));
        System.out.println(kmp("abab", "a"));
    }
}
