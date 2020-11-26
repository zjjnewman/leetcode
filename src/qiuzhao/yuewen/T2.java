package qiuzhao.yuewen;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class T2 {

    static public String removeDuplicatedChars (String str) {
        // write code here
        LinkedHashSet<Character> ls = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            ls.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character l : ls) {
            sb.append(l);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatedChars("abcbdde"));
    }
}
/*
4
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16
 */