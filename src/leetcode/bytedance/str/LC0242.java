package leetcode.bytedance.str;

/**
 * 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 */
public class LC0242 {

    // 解法1 比较直观
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] hashS = new int[256];
        int[] hashT = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            hashS[sc[i]]++;
            hashT[tc[i]]++;
        }
        for(int i = 0; i < 256; i++){
            if(hashT[i] != (hashS[i])){
                return false;
            }
        }
        return true;
    }

    // 解法2 复用
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] hash = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            hash[sc[i]]++;
            hash[tc[i]]--;
        }
        for(int i = 0; i < 256; i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }

    //解法3 排序计算hash值


}
