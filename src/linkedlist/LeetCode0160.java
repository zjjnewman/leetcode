package linkedlist;

public class LeetCode0160 {
    public static void main(String[] args) {


    }

//     * Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

     // 解法一

    /**
     *
     *交叉链表问题
     *
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            if(a==null || b==null) {
                return null;
            }

            int lenA = 1, lenB = 1;
            while(a.next!=null || b.next!=null){
                if(a.next!=null){
                    lenA++;
                    a = a.next;
                }
                if(b.next!=null){
                    lenB++;
                    b = b.next;
                }
            }

            if (!a.equals(b)){
                return null;
            }

            int i = lenA - lenB;
            a = headA;
            b = headB;
            if(i >= 0){
                while (i > 0) {
                    a = a.next;
                    i--;
                }
            } else {
                i = -i;
                while (i > 0) {
                    b = b.next;
                    i--;
                }
            }
            while(a != null){
                if(a.equals(b)){
                    return a;
                }
                a = a.next;
                b = b.next;
            }
            return null;
        }
    }


//    解法2
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            boolean isA = true;
            boolean isB = true;
            if(a == null || b == null){
                return null;
            }
            while (a != null || b != null){
                if(a != null && a.equals(b)){
                    return a;
                }
                if((a = a.next) == null && isA){
                    a = headB;
                    isA = false;
                }
                if((b = b.next) == null && isB){
                    b = headA;
                    isB = false;
                }
            }
            return null;
        }
    }

//    解法2 代码优化版
    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            while(a != b){
                a = (a == null) ? headA : a.next;
                b = (b == null) ? headB : b.next;
            }
            return a;

        }
    }
}

