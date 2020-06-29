package leetcode.bytedance;

/**
 * 8. 字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 注意：：： 这题纯粹考虑细心程度，和阅读理解能力，题目本身给出的条件就不全
 * 没有实现完全，因为很费时间，时间也很紧张。
 *
 *
 * ----------此题留坑----------
 */
public class LC0008 {

    public int myAtoi2(String str) {

        if(str == null || str.equals("")){
            return 0;
        }

        char sign = '+';
        long result = 0;

        char[] chars = str.toCharArray();
        boolean isFirstChar = true;
        for (int i = 0; i < str.length(); i++) {
            if(isFirstChar){
                if(chars[i] ==' '){
                    continue;
                }

                if((chars[i] > (int) '9' || chars[i] < (int)'0') && chars[i] != '+' && chars[i] != '-'){
                    return 0;
                }

                isFirstChar =false;

                if(chars[i] == '-' || chars[i] == '+'){
                    sign = chars[i];
                } else {
                    result = -(chars[i] - 48);
                }

            } else if(chars[i] >= (int) '0' && chars[i] <= (int)'9'){

                if((result * 10) - (long)(chars[i] - 48) <= Integer.MIN_VALUE){
                    if(sign == '-'){
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                result = (result * 10) - (long)(chars[i] - 48);
            } else if(chars[i] == '.'){
                break;
            }
        }

        if(sign == '-'){
            return (int)result;
        }
        return (int)(-result);
    }


    public int myAtoi1(String str) {

        if (str == null || str.equals("")) {
            return 0;
        }

        char sign = '\0';
        int result = 0;
        int first = 0;

        char[] chars = str.toCharArray();
        boolean isFirstChar = true;

        for (int i = 0; i < str.length(); i++) {
            if (isFirstChar) {
                if (chars[i] == ' ') {
                    continue;
                }

                if ((chars[i] > (int) '9' || chars[i] < (int) '0') && chars[i] != '+' && chars[i] != '-') {
                    return 0;
                }

                isFirstChar = false;

                if (chars[i] == '-' || chars[i] == '+') {
                    sign = chars[i];
                } else {
                    result = chars[i] - 48;
                }

            } else if (chars[i] >= (int) '0' && chars[i] <= (int) '9') {

                if (sign == '-') {
                    result = (result * 10) - (chars[i] - 48);
                } else {
                    result = (result * 10) + (chars[i] - 48);
                }
            }
        }
        return result;
    }


    public int myAtoi(String str) {

        if(str == null || str.equals("")){
            return 0;
        }

        char sign = '+';
        long result = 0;

        char[] chars = str.toCharArray();
        boolean isFirstChar = true;
        for (int i = 0; i < str.length(); i++) {
            if(isFirstChar){
                if(chars[i] ==' '){
                    continue;
                }

                if((chars[i] > (int) '9' || chars[i] < (int)'0') && chars[i] != '+' && chars[i] != '-'){
                    return 0;
                }

                isFirstChar =false;

                if(chars[i] == '-' || chars[i] == '+'){
                    sign = chars[i];
                } else {
                    result = -(chars[i] - 48);
                }

            } else if(chars[i] >= (int) '0' && chars[i] <= (int)'9'){

                if((result * 10) - (long)(chars[i] - 48) < Integer.MIN_VALUE){
                    if(sign == '-'){
                        return (int)result;
                    } else {
                        return (int)(-result);
                    }
                } else if((result * 10) - (long)(chars[i] - 48) == Integer.MIN_VALUE){
                    if(sign == '-'){
                        return (int)((result * 10) - (long)(chars[i] - 48));
                    } else {
                        return (int)(-result);
                    }
                }
                result = (result * 10) - (long)(chars[i] - 48);
            }
        }

        if(sign == '-'){
            return (int)result;
        }
        return (int)(-result);
    }

    public static void main(String[] args) {
        LC0008 l = new LC0008();
//        System.out.println(l.myAtoi("-91283472332"));
        System.out.println(l.myAtoi2("3.14159"));
//        System.out.println(l.myAtoi("12342"));

//        int a = -2147483648;
//        int b = +2147483648;
//        System.out.println((int)'9'+"    "+(int)'0');
    }
}
