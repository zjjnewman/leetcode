package qiuzhao.tengxun;

import java.util.*;

public class T1 {

    static class Node{
        public Node next;
        public int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static void method(Node h1, Node h2){
        while (h1!=null&&h2!=null){
            if(h1.val>h2.val){
                h1=h1.next;
            }else if(h1.val<h2.val){
                h2=h2.next;
            }else {
                System.out.print(h1.val+" ");
                h1=h1.next;
                h2=h2.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //链表长
        int n = scanner.nextInt();
        Node h1 =null;
        Node h2 =null;
        Node t1 =null;
        Node t2 =null;
        for (int i = 0; i < n; i++) {
            if(h1 == null){
                h1 = new Node(scanner.nextInt());
                t1 = h1;
            } else {
                t1.next = new Node(scanner.nextInt());
                t1 = t1.next;
            }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            if(h2 == null){
                h2 = new Node(scanner.nextInt());
                t2 = h2;
            } else {
                t2.next = new Node(scanner.nextInt());
                t2 = t2.next;
            }
        }
        method(h1,h2);
    }
}
