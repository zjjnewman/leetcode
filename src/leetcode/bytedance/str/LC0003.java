package leetcode.bytedance.str;

/**
 * 3. 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 类似 面试题48. 最长不含重复字符的子字符串 https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LC0003 {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int len = 0;
        int maxLen = 0;
        int[] hashArr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hashArr[s.charAt(i)]++;
            while (hashArr[s.charAt(i)] > 1){
                hashArr[s.charAt(j)]--;
                j++;
            }
            maxLen = Math.max(i + 1 - j, maxLen);
        }
        return maxLen;
    }

}
