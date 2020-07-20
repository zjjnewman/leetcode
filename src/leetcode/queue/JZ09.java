package leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 剑指 Offer 09. 用两个栈实现队列 https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class JZ09 {

    class CQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    int tmp = stack1.removeLast();
                    stack2.addLast(tmp);
                }

                if(stack2.isEmpty()){
                    return -1;
                } else {
                    return stack2.removeLast();
                }

            } else {
                return stack2.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("next: "+sc.next());
            System.out.println("int: "+sc.nextInt());
        }
    }
}
