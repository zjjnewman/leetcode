package linkedlist;

public class LeetCode0019 {
    /**
     Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p = head;
            ListNode q = head;
            while (q.next != null){
                //若链表长=n
                //1->2->3->4-5 n=5
                //p            q
                //   p       q

                //若链表长>n
                //1->2->3->4->5 n=2
                //p     q
                //      p     q
                if(n > 0){
                    q = q.next;
                    n--;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
            if (n > 0){
                return head = head.next;
            }
            p.next = p.next.next;
            //p.next.next = null; 这一步不需要
            return head;
        }
    }
}
