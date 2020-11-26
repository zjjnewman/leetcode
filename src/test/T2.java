package test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T2 {
    public static long fibonacci(long n){
        if(n <= 2){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n -  2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher m = pattern.matcher(s);
        int a = Integer.parseInt(m.replaceAll(""));
        System.out.println(fibonacci(a));
    }
}
/*
写第10个数字的 斐波那契数列
写第9个数字的 斐波那契数列
 */