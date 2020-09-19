package zhuanxiang.regex;

/**
 * 正则表达式
 */
public class Regex {

    public static boolean isMatch(String s){
        //密码验证 必须由大 小 特殊字符 数字
        String m = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^0-9a-zA-Z]).{8,}";
        boolean isMathc = s.matches(m);
        if(isMathc){
            return true;
        }
        return false;
    }

}
