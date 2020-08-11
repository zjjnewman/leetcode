package leetcode.str;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 剑指 Offer 20. 表示数值的字符串 https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */

public class JZ21 {

    /**
     * 有限自动机
     *          ' +2.5e3 '
     *          ' +2.5e-3'
     *          '   .5e3'
     *       +2
     *       +2.5
     *       +2.5e3
     *       +2.5e-3'
     *        2
     *        2.5
     *        2.5e3
     *        2.5e-3
     *         .5
     *         .5e3
     *         .5e-3
     */
    public boolean isNumber(String s) {
        /**
         * 字符表示映射
         * + -      ：s
         * 123      ：d
         * e        ：e
         * .        ：.
         * ' '      ：' '
         * sd.desd
         *
         * sd
         * sd.d
         * sd.ded
         * sd.desd
         *  d
         *  d.d
         *  d.ded
         *  d.desd
         *   .d
         *   .ded
         *   .desd
         *
         *
         * 合法的状况
         * 考虑处理字符出纳 s的办法，遇到连续的数字统一为 d
         *
         */

        s = s.trim();
        if(s.length() == 0){
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-'){
                sb.append('s');
            } else if(c >= '0' && c <='9'){
                if(i == 0 || sb.charAt(sb.length() - 1) != 'd'){ //"+124.434e-10
                    sb.append('d');
                }
            } else {
                sb.append(c);
            }
        }

        /**
         *
         *
         *      [s] :
         *           d
         *           ded
         *           desd
         *
         *           d.d
         *           d.ded
         *           d.desd
         *            .d
         *            .ded
         *            .desd
         *                   */

        s = sb.toString();
        System.out.println(s);
        HashSet<String> set = new HashSet<>();
        set.add("d");
        set.add("ded");
        set.add("desd");

        set.add("d.");
        set.add("d.d");
        set.add("d.ded");
        set.add("d.desd");
        set.add("d.ed");
        set.add("d.esd");

        set.add(".d");
        set.add(".ded");
        set.add(".desd");


        if(s.charAt(0) == 's'){
            return set.contains(s.substring(1, s.length()));
        } else {
            return set.contains(s);
        }
    }













    public boolean isNumber1(String s) {
        /**
         * 符号特性：
         *      '+' '-'：必须在最前面，且在数字前面
         *      '.'： 两边必须是数字
         *      'e': 两边必须是数字
         *
         * 规则特性：
         *      'e'：后面不能有 + - .
         *      三个符号必须由数字隔开
         *      e . + 后面必须是数字
         *
         * 字符出现示例：
         *          +2.5e3
         *          2.5e3
         *
         * 单调栈：
         *      维持栈size为3的单调栈，size有几种情况
         *              size：顺序必须是 + . e，且之间有数字隔开，且符号后面必须有数字
         *                  3   +2.5e3
         *                  2   +2.5    2.5e3   +2e3
         *                  1   +2      2.5     2e3
         *
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();

        // 必须以 + - 数字开头
        if(s.length() == 0 || (s.charAt(0) != '+' && s.charAt(0) != '-' && (s.charAt(0) > '9' || s.charAt(0) < '0'))){
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 1; i < s.length(); i++) {
            if(!isRightChar(s.charAt(i))){
                return false;
            }

            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == 'e' || s.charAt(i) == '.'){
                stack.addLast(i);
            }
        }

        if (stack.size() > 3){
            return false;
        }else if (stack.size() == 3){
            int right = stack.poll();
            int mid = stack.poll();
            int left= stack.poll();
            if(left == 0 && (s.charAt(left) == '+' || s.charAt(left) == '-') && s.charAt(mid) == '.' && s.charAt(right) == 'e'){
                if(s.charAt(left + 1) <= '9' && s.charAt(left + 1) >= '0'
                        && s.charAt(mid - 1) <= '9' && s.charAt(mid - 1) >= '0'
                        && s.charAt(mid + 1) <= '9' && s.charAt(mid + 1) >= '0'
                        && s.charAt(right - 1) <= '9' && s.charAt(right - 1) >= '0'
                        && right + 1 < s.length()
                        && s.charAt(right + 1) <= '9' && s.charAt(right + 1) >= '0'){
                    return true;
                }
            }
            return false;

        }else if(stack.size() == 2){//2   +2.5    2.5e3   +2e3  .5e3
            int right = stack.poll();
            int left= stack.poll();
            if(left == 0){
                if((s.charAt(left) == '+' || s.charAt(left) == '-')
                        && s.charAt(left + 1) <= '9' && s.charAt(left + 1) >= '0'
                        && s.charAt(right - 1) <= '9' && s.charAt(right - 1) >= '0'
                        && right + 1 < s.length()
                        &&s.charAt(right + 1) <= '9' && s.charAt(right + 1) >= '0'){
                    return true;
                }
                return false;
            } else {
                if(s.charAt(left) == '.' && s.charAt(right) == 'e'
                        && s.charAt(left - 1) <= '9' && s.charAt(left - 1) >= '0'
                        && s.charAt(left + 1) <= '9' && s.charAt(left + 1) >= '0'
                        && s.charAt(right - 1) <= '9' && s.charAt(right - 1) >= '0'
                        && right + 1 < s.length()
                        &&s.charAt(right + 1) <= '9' && s.charAt(right + 1) >= '0'){
                    return true;
                }
                return false;
            }

        }else if(stack.size() == 1){//1   +2      2.5     2e3
            int left = stack.poll();
            if(left == 0){
                if((s.charAt(left) == '+' || s.charAt(left) == '-')
                        && left + 1 < s.length()
                        && s.charAt(left + 1) <= '9' && s.charAt(left + 1) >= '0'){
                    return true;
                }
                return false;
            } else {
                if(s.charAt(left - 1) <= '9' && s.charAt(left - 1) >= '0'
                        && left + 1 < s.length()
                        && s.charAt(left + 1) <= '9' && s.charAt(left + 1) >= '0'){
                    return true;
                }
                return false;
            }
        }else {
            return true;
        }
    }

    // 必须是 + - 数字 e 字符，出现其他字符，出错
    private boolean isRightChar(char c){
        if((c > '9' || c < '0') && c != 'e' && c != '+' && c != '-' && c != '.'){
            return false;
        }
        return true;
    }




    public static void main(String[] args) {
        /**
         * double 小数点后15位
         * float 小数点后5位
         */
        double d = 5.12345678901234567899977777777777777777777777777777777777777777;
        float f = 5.123456789012345678999777777777777777777777777777777777777777777f;
        System.out.println(d);
        System.out.println(f);

        DecimalFormat format = new DecimalFormat("0.0000");
        System.out.println(format.format(d));
        System.out.println(format.format(f));

        System.out.println(String.format("%.5f", f));

        JZ21 t = new JZ21();
        System.out.println("----------------------");
        System.out.println((int)6.e3);
        System.out.println(t.isNumber(" 005047e+6"));

    }
}