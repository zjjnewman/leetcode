package leetcode.linkedlist;

public class LeetCode0234 {

//    Definition for singly-linked list.

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode p = head;
            int len = 0;
            while (p != null){
                len ++;
                p = p.next;
            }
            if (len == 0 || len == 1){
                return true;
            }
            if (len == 2){
                return head.val == head.next.val;
            }

            p = head;
            ListNode q = head.next;
            ListNode h = null;
            int mid =len / 2;

//       翻转链表 以下迭代展示
//       null<-1->2->3
//          h<-p  q
//             h<-p  q
            while (mid-1 > 0){
                mid--;
                p.next = h;
                h = p;
                p = q;
                q = q.next;
            }
//          迭代到最后p指针悬空，需要指向翻转后的临时头；
            p.next = h;

//以下注释代码该进程下面的形式
//            if(len % 2 != 0){
//               ListNode n1 = new ListNode(q.val);
//               n1.next = p;
//               p = n1;
//            }
            if(len % 2 != 0){
                q = q.next;
            }
            while (p != null){
                if(p.val != q.val){
                    return false;
                }
                p = p.next;
                q = q.next;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0234().new Solution().isPalindrome(null));
    }
}
