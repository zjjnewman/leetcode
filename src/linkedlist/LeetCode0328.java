package linkedlist;

/**
 * @author jin
 */
public class LeetCode0328 {

    //Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null || head.next.next == null){
                return head;
            }

            int len = 0;
            ListNode p = head;
            ListNode tail;
            while (p.next != null){
                len++;
                p = p.next;
            }

            len = len + 1;
            tail = p;
            p = head;

            //偶数个数为迭代次数
            int evenNum = len/2;
            while (evenNum > 0){
                evenNum--;
                tail.next = p.next;
                tail = tail.next;
                p.next = p.next.next;
                tail.next = null;
                p = p.next;
            }
            return head;
        }
    }
}
