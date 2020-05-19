package linkedlist;

import java.util.Objects;

public class LeetCode0083 {
    /**
     *
     * Definition for singly-linked list.
     */
     static public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode p = head;
            ListNode q = head.next;
            while (q != null){
                //这里条件改成p != q 则方法错误
                if (p.val != q.val) {
                    p.next = q;
                    p = q;
                }
                q = q.next;
            }
            p.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution sl = new LeetCode0083().new Solution();
        sl.deleteDuplicates(n1);
        ListNode tmp =n1;
//        while (tmp != null){
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }
        System.out.println(n2.equals(n3));
        n2.next = null;
        n3.next = null;
        System.out.println(n2==n3);
        System.out.println(n2==n3);
    }
}
