package linkedlist;

public class Leetcode0024 {


//      Definition for singly-linked list.

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution2 sl = new Leetcode0024().new Solution2();

        ListNode p = sl.swapPairs(n1);
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }



//        ListNode h = null;
//        ListNode p = n1;
//        ListNode q = n1.next;
//        while (p != null && p.next != null) {
//            p.next = q.next;
//            q.next = p;
//            if (h != null) {
//                h.next = q;
//            }
//
//            //交换p q值准备下一次迭代
//            h = p;
//            p = q;
//            q = h;
//
//            p = q.next;
//            q = p.next;

            //以下的边界条件会抛出空指针异常，是因为第2句, 举例说明：
            // 有p->q, 则p.next = q != null, 所以p.next 指针并不是空 p.next.next = q.next == null
            // q.next = null 那么 q = q.next.next 可转换为 q = null.next 为空指针异常
            //p = p.next.next;
            //q = q.next.next;
    }


    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //   1->2->3->4->5->6, 你应该返回 2->1->4->3->6->5.
            //h  p->q
            //   q  p
            //      h  p  q
            ListNode bk = head.next;
            ListNode h = null;
            ListNode p = head;
            ListNode q = head.next;

            while (true) {
                p.next = q.next;
                q.next = p;
                if (h != null) {
                    h.next = q;
                }

                //交换p q值准备下一次迭代
                h = p;
                p = q;
                q = h;

                if ((p = p.next.next) == null || (q = q.next.next) == null) {
                    break;
                }
            }
            return bk;
        }
    }

    class Solution2{
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //   1->2->3->4->5->6, 你应该返回 2->1->4->3->6->5.
            //h  p->q
            //   q  p
            //      h  p  q
            ListNode nh = new ListNode(0);
            nh.next = head;
            ListNode p = nh;
            ListNode q = head.next;

            while (true){
                p.val  = q.val;
                if(q.next == null){
                    p.next.next = null;
                    break;
                }
                if(q.next.next == null){
                    p.next.next = q.next;
                    q.next = null;
                    break;
                }
                p = q;
                q = p.next.next;
            }
            return nh;
        }
    }

}

