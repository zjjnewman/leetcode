package qiuzhao.dianxinyun;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class T3 {

    private static LinkedList<Integer> stack = new LinkedList<>();

    static public void push(int val){
        stack.push(val);
    }

    static public int pop(){
        return stack.pop();
    }

    static public int top(){
        return stack.peek();
    }
    static public int getMin(){
        int min = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if(integer < min){
                min = integer;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] operate = s.split(" ");
            if(operate[0].equals("push")){
                push(Integer.parseInt(operate[1]));
            } else if(operate[0].equals("pop")){
                pop();
            } else if(operate[0].equals("top")){
                list.add(top());
            } else if(operate[0].equals("getMin")){
                list.add(getMin());
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
