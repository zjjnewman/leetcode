package linkedlist;

public class LeetCode0206 {
//    Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
//20200517

//  <-1  2->3->4->5
// h  p  q
//    1<-2  3->4->5
//    h  p  q
//    1<-2<-3  4->5
//       h  p  q
//    1<-2<-3<-4  5
//          h  p  q
//    1<-2<-3<-4<-5
//             h  p  q
//    1->2->3->4<-5
//解法1 迭代

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode h = null;
            ListNode p = head;
            ListNode q = p.next;
            while (q != null){
                p.next = h;
                h = p;
                p = q;
                q = q.next;
            }
            p.next = h;
            return p;
        }
    }

    //解法2 递归

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode p = head.next;
        ListNode newHead = reverseList(p);
        p.next = head;
        head.next = null;
        return newHead;
    }
}


