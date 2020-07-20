package leetcode.linkedlist;

/**
 * 剑指 Offer 06. 从尾到头打印链表 https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class JZ04 {

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public int[] reversePrint(ListNode head) {

            if(head == null){
                return new int[]{};
            }

            ListNode pre = null;
            ListNode curr = head;
            ListNode next = curr.next;

            int len = 0;
            while (next != null){
                len++;
                curr.next = pre;
                pre = curr;
                curr = next;
                next = next.next;
            }
            len++;
            curr.next = pre;

            head = curr;

            int[] arr = new int[len];

            int i = 0;
            while (curr != null){
                arr[i] = curr.val;
                curr = curr.next;
                i++;
            }
            return arr;
        }
    }
}
