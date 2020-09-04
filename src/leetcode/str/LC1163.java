package leetcode.str;

import sun.misc.Cache;

import java.awt.*;
import java.util.ArrayList;

/**
 * 1163. 按字典序排在最后的子串 https://leetcode-cn.com/problems/last-substring-in-lexicographical-order/
 */
public class LC1163 {

    public static String lastSubstring(String s) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> strArr = new ArrayList<>();
            for (int j = i + 1; j <= s.length(); j++) {
                strArr.add(s.substring(i, j));
            }
            lists.add(strArr);
        }
        System.out.println(lists.toString());
        return "";
    }

    static private void sort(ArrayList<String> a){

    }

    public static void main(String[] args) {
        System.out.println(lastSubstring("abab"));
    }
}
