package qiuzhao.xiaomi;

import java.util.Scanner;

public class T1 {

    public static int check(String str){
        if(str.length() < 8 || str.length()>120){
            return 1;
        }
        String rexNum = "[0-9]";
        String rexStrB = "[A-Z]";
        String rexStrS = "[A-z]";
        String rexSingle = "[`._~!@#$%^&*(){}/\\|><,?]";
        String match = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])" +
                "(?=.*[`._~!@#$%^&*(){}/\\|><,?])[A-Za-z0-9`._~!@#$%^&*(){}/\\|><,?]{8,}";

        boolean isMathc = str.matches(match);
        if(!isMathc){
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inS = scanner.nextLine();
        String[] strs = inS.split(" ");
        for (String str : strs) {
            System.out.println(check(str));
        }

    }
}
