package leetcode.stack;

import leetcode.bytedance.linkedlist.LC0025;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * -----char 不能用 '== null' -----
 *
 * 20. 有效的括号  https://leetcode-cn.com/problems/valid-parentheses/submissions/
 */

public class LC0020 {

    HashMap<Character, Character> map = new HashMap<>();

    {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid1(String s) {
        if(s == null || s.length()%2 != 0){
            return false;
        }

        char[] sc = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        int i = 0;
        while (i < s.length()){

            if(!stack.isEmpty() && !map.containsKey(stack.peek())){
                return false;
            }

            if(!stack.isEmpty() && map.get(stack.peek()) == sc[i]){
                stack.pop();
            } else {
                stack.push(sc[i]);
            }

            i++;
        }


        return stack.isEmpty();
    }


    public boolean isValid(String s) {

        if(s == null || s.length()%2 != 0){
            return false;
        }

        LinkedList<Character> stack = new LinkedList<>();
        char[] sc = s.toCharArray();
        int i = 0;

        while (i < s.length()){
            if(!stack.isEmpty() && !map.containsKey(stack.peek())){
                return false;
            }
            if(!stack.isEmpty() && map.get(stack.peek()) == sc[i]){
                stack.pop();
            } else {
                stack.push(sc[i]);
            }
            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC0020 l = new LC0020();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);

        String s = "adnc";
        char[] sc = s.toCharArray();


        System.out.println(l.isValid("()"));

//        System.out.println(stack.peek());

//        System.out.println('d' == 'c');
    }
}
