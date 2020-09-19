package qiuzhao.jingdong;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            String group = matcher.group();
            if (Integer.parseInt(group) >= 1000 && Integer.parseInt(group) <= 3999){
                System.out.print(group + " ");
            }
        }
    }
}
