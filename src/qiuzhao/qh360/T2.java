package qiuzhao.qh360;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class T2 {


    public static boolean isMatch(String s){
        //密码验证 必须由大 小 特殊字符 数字
        String m = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^0-9a-zA-Z]).{8,}";
        boolean isMathc = s.matches(m);
        if(isMathc){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String s = sc.nextLine();
            if(isMatch(s)){
                System.out.println("Ok");
            } else {
                System.out.println("Irregular password");
            }
        }
    }
}
