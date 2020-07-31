package leetcode.linkedlist;

import java.util.List;

/**
 * 剑指 Offer 18. 删除链表的节点 https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class JZ18 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode node = head;
            ListNode pre = null;

            while (node != null){

                if(pre == null && node.val == val){
                    return node.next;
                }

                if(node.val == val){
                    pre.next = node.next;
                    node.next = null;
                    break;
                }
                pre = node;
                node = node.next;
            }

            return head;
        }
    }
}
