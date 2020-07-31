package leetcode.linkedlist;


import java.awt.*;
import java.awt.event.WindowListener;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class JZ12 {
     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if(k == 0){
                return null;
            }
            if(head == null){
                return head;
            }

            ListNode node = head;
            int len = 0;
            while (node != null){
                len++;
                node = node.next;
            }

            if (k > len){
                return null;
            }

            k = len - k;
            node = head;
            while (k > 0){
                k--;
                node = node.next;
            }
            return node;
        }
    }
}
