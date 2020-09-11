package qiuzhao.meituan;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    public static String isMatch(String str){

        /**
         * 正则表达式，匹配 = 字母开头，必须包含数字，且只有字母数字。
         */
        // 只能包括字母数字
        String uPattern1 = "^[a-zA-Z0-9]{2,20}$";
        // 必须字母开头。
        String uPattern2 = "^(?=[a-zA-Z]).*(?=.{2,20})(?=.*\\d)(?=.*[a-zA-Z]).*$";

        if(Pattern.matches(uPattern1, str) && Pattern.matches(uPattern2, str)){
            return "Accept";
        }
        return "Wrong";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String match = isMatch(scanner.next());
            System.out.println(match);
        }
    }
}


/*
function done(input){
    var uPattern1 = /^[a-zA-Z0-9]{2,20}$/;
    var uPattern2 = /^(?=[a-zA-Z]).*(?=.{2,20})(?=.*\d)(?=.*[a-zA-Z]).*$/;
    if (input.match(uPattern1) && input.match(uPattern2)) {
        return true;
    } else {
        return false;
    }
}
console.log(done("antzone"));


function done(input){
    var uPattern1 = /^\/(\w+\/?)[a-z]$/;
    if (input.match(uPattern1)) {
        return true;
    } else {
        return false;
    }
}
console.log(done("antzone"));


*/