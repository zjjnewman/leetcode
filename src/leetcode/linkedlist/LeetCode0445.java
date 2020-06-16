package leetcode.linkedlist;

import java.util.Stack;

public class LeetCode0445 {

    //Definition for singly-linked list.

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1.val == 0){
                return l2;
            }
            if(l2.val == 0){
                return l1;
            }
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            while (l1 != null || l2 !=null){
                if(l1 != null){
                    s1.push(l1.val);
                    l1 = l1.next;
                }
                if(l2 != null){
                    s2.push(l2.val);
                    l2 = l2.next;
                }
            }

            int a = 0;
            int b = 0;
            int c = 0;
            ListNode p;
            ListNode nh = null;
            int isCarry = 0;

            while (!s1.empty() || !s2.empty()){
                a = s1.empty() ? 0 : s1.pop();
                b = s2.empty() ? 0 : s2.pop();
                c = a+b+isCarry;
                if(c >= 10){
                   p = new ListNode(c % 10);
                   isCarry = 1;
                } else {
                    p = new ListNode(c);
                    isCarry = 0;
                }
                p.next = nh;
                nh = p;
            }
            if(isCarry == 1){
                p = new ListNode(1);
                p.next = nh;
                nh = p;
            }
            return nh;
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1.val == 0){
                return l2;
            }
            if(l2.val == 0) {
                return l1;
            }
            int len1 = 0;
            int len2 = 0;
            ListNode p = l1;
            ListNode q = l2;
            while (p != null || q != null){
                if(p != null){
                    p = p.next;
                    len1++;
                }
                if(q != null){
                    q = q.next;
                    len2++;
                }
            }
            int carryArrlen;
            int i = len1 - len2;
            if(i < 0){
                //这一步忘记了
                i = -i;
                p = l2;
                q = l1;
                carryArrlen = len2 + 1;
            } else {
                p = l1;
                q = l2;
                carryArrlen = len1 + 1;
            }
            int[] carryArr = new int[carryArrlen];
            int caIdx = 1;

            ListNode nHead = p;
            while (i > 0){
                carryArr[caIdx] = p.val;
                p = p.next;
                i--;
                caIdx++;
            }
            while (p != null){
                p.val = p.val + q.val;
                carryArr[caIdx] = p.val;
                caIdx++;
                p = p.next;
                q = q.next;
            }
            caIdx = carryArrlen - 1;
            while (caIdx > 0){
                if(carryArr[caIdx] >= 10){
                    carryArr[caIdx] = carryArr[caIdx] % 10;
                    carryArr[caIdx - 1] = carryArr[caIdx - 1] + 1;
                }
                caIdx--;
            }
            p = nHead;
            caIdx = 1;
            while (p != null){
                p.val = carryArr[caIdx];
                p = p.next;
                caIdx++;
            }
            if(carryArr[0] != 0){
                p = new ListNode(1);
                p.next = nHead;
                nHead = p;
            }

            return nHead;
        }
    }

    public static void main(String[] args) {
         ListNode n1 = new ListNode(1);
         ListNode n2 = new ListNode(9);
         ListNode n3 = new ListNode(9);
         n2.next = n3;
         new LeetCode0445().new Solution2().addTwoNumbers(n1, n2);
         ThreadLocal<Integer> tl = new ThreadLocal();
         Thread t = new Thread();


         for(int i = 10; i > 0; i--){
             System.out.println();
         }


    }

}
