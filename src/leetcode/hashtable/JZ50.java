package leetcode.hashtable;


import sun.tools.jconsole.CreateMBeanDialog;

/**
 * @date 2020-06-20
 * 剑指 Offer 50. 第一个只出现一次的字符 https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 */
public class JZ50 {

    class Solution {
        public char firstUniqChar(String s) {
            int[] hashArr = new int[256];
            int j = 0;
            for (int i = 0; i < s.length(); i++){
                hashArr[s.charAt(i)]++;
                while (j < s.length() && hashArr[s.charAt(j)] != 1){
                    j++;
                }
            }
            return (j == s.length()) ? ' ' : s.charAt(j);
        }



        public char firstUniqChar1(String s) {
            int[] hashArr = new int[256];
            int j = 0;
            for (int i = 0; i < s.length(); i++){
                hashArr[s.charAt(i)]++;
            }
            int i = 0;
            while (i < s.length()){
                if(hashArr[s.charAt(i)] == 1){
                    break;
                }
                i++;
            }
            if(i < s.length()){
                return s.charAt(i);
            }
            return ' ';
        }
    }

}
