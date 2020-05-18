package linkedlist;

import java.util.List;

public class LeetCode0021 {


    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int x) { val = x; }
    }

//20200517
// 参考答案解法

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) {
                return l2;
            }
            if(l2 == null) {
                return l1;
            }
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

//    解法2
//    ::::::: 注意！！！ 这个题我单独写了 swap方法交换l1 l2引用，但是这种办法只能在swap内有用 方法外失效

    class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) {
                return l2;
            }
            if(l2 == null) {
                return l1;
            }
            ListNode tail = null;
            ListNode tmp;
//            始终保持l1 l2种了l1的val最小
            if(l1.val > l2.val){
                tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            ListNode h = l1;

            while (true){
                tail = l1;
                l1 = l1.next;
                if(l1 == null){
                    tail.next = l2;
                    break;
                }
                // 始终保持l1 l2种了l1的val最小
                if(l1.val > l2.val){
                    tail.next = l2;

                    tmp = l1;
                    l1 = l2;
                    l2 = tmp;
                }
            }
            return h;
        }


    }
    public static void main(String[] args) {
        LeetCode0021 lc = new LeetCode0021();

        ListNode n1 = new LeetCode0021().new ListNode(1);
        ListNode n2 = new LeetCode0021().new ListNode(2);
        ListNode n3 = new LeetCode0021().new ListNode(4);
        ListNode n4 = new LeetCode0021().new ListNode(1);
        ListNode n5 = new LeetCode0021().new ListNode(3);
        ListNode n6 = new LeetCode0021().new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next=null;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        Solution2 sl = new LeetCode0021().new Solution2();
        ListNode h = sl.mergeTwoLists(n1, n4);
        ListNode tmp = n1;
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }

    }

}
