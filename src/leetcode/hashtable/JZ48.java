package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020-06-16
 * 需要用到kmp(用到kmp这个错误，重新考虑)
 * 面试题48. 最长不含重复字符的子字符串 https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class JZ48 {
    class Solution {


        //双指针法
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int tmpMax = 0;
            int l = 0;
            int[] hashArr = new int[256];
            for (int i = 0; i < s.length(); i++) {
                hashArr[s.charAt(i)]++;
                while (hashArr[s.charAt(i)] > 1){
                    hashArr[s.charAt(l)]--;
                    l++;
                }
                tmpMax = Math.max(tmpMax, i + 1 - l);
            }
            return tmpMax;
        }

        public int lengthOfLongestSubstring3(String s) {
             if(s == null || s.length() == 0){
                 return 0;
             }
             int tmpMax = 0;
             int tmpLen = 0;
             int[] hashArr = new int[256];

             for(int i = 0; i < s.length(); i++){
                 for(int j = i; j < s.length(); j++){
                     if( hashArr[s.charAt(j)] == 0){
                         hashArr[(int) s.charAt(j)]++;
                         tmpLen++;
                         tmpMax = Math.max(tmpLen, tmpMax);
                     } else {
                         for(int k = i; k <= j; k++){
                             hashArr[(int)s.charAt(k)] = 0;
                         }
                         tmpLen = 0;
                         break;
                     }
                 }
             }
             return tmpMax;
        }




        //以下效率太慢，能不能有个效率比较高的？
        public int lengthOfLongestSubstring2(String s) {
            Map<Character,Object> map = new HashMap<>();
            Object o = new Object();
            int tmpMax = 0;
            int cnt;
            for(int i = 0; i < s.length(); i++){
                for(int j = i; j < s.length(); j++){
                    if(! map.containsKey(s.charAt(j))){
                        map.put(s.charAt(j),o);
                        tmpMax = Math.max(map.size(), tmpMax);
                    } else {
                        map.clear();
                        break;
                    }
                }

            }
            return tmpMax;
        }

        //以下是错误答案，因为不重复字符的约束小于前后无重复子串。
        public int lengthOfLongestSubstring1(String s) {
            int[] next = new int[s.length()];
            next = kmpNext(s);
            int cnt = 0;
            int tmpMax = 0;
            for(int i = 0; i < s.length(); i++){
                cnt++;
                if (next[i] == 0) {
                    if(tmpMax < cnt){
                        tmpMax = cnt;
                    }
                } else {
                    cnt = 0;
                }
            }
            return tmpMax;
        }

        public int[] kmpNext(String s){
            int[] nextArr = new int[s.length()];
            int i = 0;
            int j = -1;
            nextArr[0] = -1;

            while(i < s.length() - 1 ){
                if(j == -1 || s.charAt(i) == s.charAt(j)){
                    j++;
                    i++;
                    nextArr[i] = j;
                } else {
                    j = nextArr[j];
                }
            }
            return nextArr;
        }
    }

    public static void main(String[] args) {
        System.out.println(new JZ48().new Solution().lengthOfLongestSubstring("au"));
    }
}
