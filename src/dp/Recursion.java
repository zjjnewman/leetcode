package dp;

import datastructure.LNode;

public class Recursion {

    /**
     * 递归的基础，函数接力。
     *
     * n的阶乘
     */
    public static long factorial1(long n){
        if(n == 1){
            return n;
        } else {
            return n * factorial1(n - 1);
        }
    }

    public static long factorial2(long n){
        if(n == 1){
            return n;
        }
        long a = 1;
        long i = 1;
        while (i <= n){
            a = a * i;
            i = i + 1;
        }
        return a;
    }

    // 斐波那契迭代版
    public static long fibonacci1(long n){
        if(n <= 2){
            return 1;
        } else {
            long a = 1;
            long b = 1;
            long k = (n - 2) >> 1;
            while (k > 0){
                a = a + b;
                b = b + a;
                k--;
            }
            return n % 2 == 0 ? b : a + b;
        }
    }
    // 斐波那契递归版
    public static long fibonacci2(long n){
        if(n <= 2){
            return 1;
        } else {
            return fibonacci2(n - 1) + fibonacci2(n -  2);
        }
    }

    // 翻转链表
    public LNode reverseList(LNode head){
        if(head == null || head.next == null){
            return head;
        } else {
            LNode newHead = reverseList(head.next);
            LNode n = head.next;
            head.next = null;
            n.next = head;
            return newHead;
        }
    }


    public static void main(String[] args) {
        System.out.println(Recursion.factorial1(5));
        System.out.println(Recursion.factorial1(5));
        int n = 100;
        System.out.println(Recursion.fibonacci1(n));
//        System.out.println(Recursion.fibonacci2(n));
    }
}
