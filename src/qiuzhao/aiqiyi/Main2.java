package qiuzhao.aiqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(s.length()==0||stack.size()==0||map.get(c)!=stack.pop()){
                    return false;
                }
            }
        }
        return  stack.size()==0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if(isValid(next)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
