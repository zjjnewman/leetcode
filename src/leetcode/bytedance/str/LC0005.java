package leetcode.bytedance.str;

/**
 * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最先想到的是中心扩散法（当时并不知道这是中心扩散，看了题解后才知道，一遍过，我都震惊了。）
 * 然后这是个 《动态规划》
 *
 */
public class LC0005 {
    //清爽版
    //试着改造成char数组看看效率
    public String longestPalindrome4(String s) {
        if(s.length() == 1 || s.length() == 0){
            return s;
        }

        char[] chars = s.toCharArray();
        String tmpMax = "";
        int lowMin = 0;
        int highMax = 0;

        for (int i = 0; i < s.length(); i++) {

            int low = i - 1;

            while (i+1 < s.length() && chars[i] == chars[i+1]){
                i++;
            }

            int high = i + 1;

            while (low >= 0 && high < s.length()){
                if(chars[low] == chars[high]){
                    low--;
                    high++;
                } else {
                    break;
                }
            }

            if((highMax - lowMin) < ((high - 1) - (low + 1))){
                highMax = high - 1;
                lowMin = low + 1;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = lowMin; i <= highMax; i++){
            sb.append(chars[i]);
        }

        return sb.toString();
    }



    public String longestPalindrome(String s) {
        if(s.length() == 1 || s.length() == 0){
            return s;
        }

        /**
         * 初步想法是中心对称遍历，中心点i不会倒退只会往前走，如果中心点右侧有同值，则把同值纳入中心点（多个中心点），
         * 原因是，若与中心点相连的右侧n个点，与中心点同值，则这n+1个点必为中心点，因为两侧必须对称。
         * 此时下一个i值为与这次中心点不同值的下一个点。
         */
        String tmpMax = "";
        for (int i = 0; i < s.length(); i++) {
            /**
             * 下面是镜像坐标
             * 要根据不同的情况求得镜像坐标的起始点，大致来说就是
             * 看中心点向前的方向有没有同值，若同值则继续向前，直到求得与中心点相连的同值总个数，
             * 此时记录high的值，下次中心点位置是high+1，因为中心点两侧同值点必相等
             * 整个迭代就是不断求low high的并对比串长的过程
             */

            int sameLen = 0;
            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            //中心值的左一个值必和中心值不同，因为下面的循环
            int low = i - 1;
            //求得和中心值相连同值个数
            while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                sameLen++;
                i++;
            }

            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            int high = i + 1;

            while (low >= 0 && high < s.length()){
                if(s.charAt(low) == s.charAt(high)){
                    low--;
                    high++;
                } else {
                    break;
                }
            }

            if(tmpMax.length() < s.substring(low+1, high).length()){
                tmpMax = s.substring(low+1, high);
            }

        }

        return tmpMax;
    }


    //试着改造成char数组看看效率
    public String longestPalindrome1(String s) {
        if(s.length() == 1 || s.length() == 0){
            return s;
        }

        /**
         * 初步想法是中心对称遍历，中心点i不会倒退只会往前走，如果中心点右侧有同值，则把同值纳入中心点（多个中心点），
         * 原因是，若与中心点相连的右侧n个点，与中心点同值，则这n+1个点必为中心点，因为两侧必须对称。
         * 此时下一个i值为与这次中心点不同值的下一个点。
         */
        char[] chars = s.toCharArray();

        String tmpMax = "";
        int lowMin = 0;
        int highMax = 0;


        for (int i = 0; i < s.length(); i++) {
            /**
             * 下面是镜像坐标
             * 要根据不同的情况求得镜像坐标的起始点，大致来说就是
             * 看中心点向前的方向有没有同值，若同值则继续向前，直到求得与中心点相连的同值总个数，
             * 此时记录high的值，下次中心点位置是high+1，因为中心点两侧同值点必相等
             * 整个迭代就是不断求low high的并对比串长的过程
             */

            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            //中心值的左一个值必和中心值不同，因为下面的循环
            int low = i - 1;
            //求得和中心值相连同值个数
            while (i+1 < s.length() && chars[i] == chars[i+1]){
                i++;
            }

            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            int high = i + 1;

            while (low >= 0 && high < s.length()){
                if(chars[low] == chars[high]){
                    low--;
                    high++;
                } else {
                    break;
                }
            }

            if((highMax - lowMin) < ((high - 1) - (low + 1))){
                highMax = high - 1;
                lowMin = low + 1;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = lowMin; i <= highMax; i++){
            sb.append(chars[i]);
        }

        return sb.toString();
    }


    /**
     * 结论，string 数组不如改成char数组快
     * @param s
     * @return
     */
    //再来一个优化测试
    //优化最后的字符串，改为字符串下标记录
    public String longestPalindrome2(String s) {
        if(s.length() == 1 || s.length() == 0){
            return s;
        }

        /**
         * 初步想法是中心对称遍历，中心点i不会倒退只会往前走，如果中心点右侧有同值，则把同值纳入中心点（多个中心点），
         * 原因是，若与中心点相连的右侧n个点，与中心点同值，则这n+1个点必为中心点，因为两侧必须对称。
         * 此时下一个i值为与这次中心点不同值的下一个点。
         */
        String tmpMax = "";
        int lowMin = 0;
        int highMax = 0;


        for (int i = 0; i < s.length(); i++) {
            /**
             * 下面是镜像坐标
             * 要根据不同的情况求得镜像坐标的起始点，大致来说就是
             * 看中心点向前的方向有没有同值，若同值则继续向前，直到求得与中心点相连的同值总个数，
             * 此时记录high的值，下次中心点位置是high+1，因为中心点两侧同值点必相等
             * 整个迭代就是不断求low high的并对比串长的过程
             */

            int sameLen = 0;
            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            //中心值的左一个值必和中心值不同，因为下面的循环
            int low = i - 1;
            //求得和中心值相连同值个数
            while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                sameLen++;
                i++;
            }

            //若这个位置的下一次循环中， i=i+1 此时i为上次循环中心值右侧的第一个不同值
            int high = i + 1;

            while (low >= 0 && high < s.length()){
                if(s.charAt(low) == s.charAt(high)){
                    low--;
                    high++;
                } else {
                    break;
                }
            }

            if((highMax - lowMin) < ((high - 1) - (low + 1))){
                highMax = high - 1;
                lowMin = low + 1;
            }

        }
        return s.substring(lowMin, highMax+1);
    }


    public int[] kmpNext(String str){
        int i = 0;
        int j = -1;
        int[] next = new int[str.length()];
        next[0] = -1;

        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


    public static void main(String[] args) {
//        //从输入中得到数据并处理
//        Scanner scanner = new Scanner(System.in);
////        String str = scanner.nextLine();
//        int num = scanner.nextInt();
//
//        for (int i = 0; i < num; i++) {
//            System.out.println(scanner.nextInt());
//        }


    }
}
