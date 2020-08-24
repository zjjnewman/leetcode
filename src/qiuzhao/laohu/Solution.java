package qiuzhao.laohu;



public class Solution {

    public static class ListNode {
        public int val;
        public ListNode next = null;
    }

    /**
     * 奇偶链表
     * 排队
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode lineUp (ListNode head) {
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

    public static void main(String[] args) {

    }
}
