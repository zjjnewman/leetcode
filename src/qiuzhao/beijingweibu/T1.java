package qiuzhao.beijingweibu;

import java.util.*;


public class T1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 字符串查找
     * @param s string字符串 被查找的字串
     * @param pattern string字符串 要查找的模式串
     * @return int整型
     */
    static public int indexOf (String s, String pattern) {
        // write code here
        if(s==null||s.length()==0){
            return -1;
        }
        return kmp(s, pattern);
    }


    static public int kmp(String s, String p){
        int[] next = next(p);
        int i=0,j=0;

        while(i < s.length()){
            if(j==p.length()-1 && s.charAt(i)==p.charAt(j)){
                return i-j;
            }
            if(s.charAt(i)==p.charAt(j)){
                i++; j++;
            }else{
                j = next[j];
                if(j==-1){
                    j++;i++;
                }
            }
        }
        return -1;
    }

    static public int[] next(String p){
        int[] next = new int[p.length()];
        next[0]=-1;
        int i = 0,j=-1;
        while(i<p.length()-1){
            if(j==-1||p.charAt(i) == p.charAt(j)){
                i++;
                j++;
                next[i]=j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abc", "bc"));
    }
}
