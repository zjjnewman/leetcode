package leetcode.bytedance.linkedlist;

import java.util.List;

/**
 * 25. K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 206. 翻转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 一开始就想到了解法，但是边界条件太难搞定
 */
public class LC0025 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {


        ListNode reverseList(ListNode head) {

            if(head == null || head.next == null){
                return head;
            }

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = head.next;
            ListNode kthPrev = null;

            int cnt = 0;
            while (next != null){
                curr.next = prev;
                prev = curr;
                curr = next;
                next = next.next;
            }
            prev = kthPrev;
            kthPrev = curr;
            curr.next = prev;


            return null;
        }

        static public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || head.next == null || k == 1 || k == 0){
                return head;
            }
            ListNode p = head;

            // 计算链表长度，从而算出按k能有多少分组
            int len = 0;
            while ( p != null){
                len++;
                p = p.next;
            }
            if(k > len){
                return head;
            }

            int group = len/k;

            // 初始化指针三巨头
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = head.next;

            // 新表头
            ListNode newHead = null;
            // 是不是第一组
            boolean isFirst = true;

            // 记录上一组，翻转之前的的表头
            ListNode preKHead = null;

            // 记录当前组，翻转之前的表头
            ListNode curKHead = head;

            // 按k个节点分组的，计算出可以分多少组，对这些组分别翻转。最后不足k个的组不处理，只需要把开始的表头指向它的头节点
            for (int i = 1; i <= group ; i++) {

                int cnt = 0;

                // 对每个分组循环翻转
                while (cnt < k && next != null){
                    cnt++;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    next = next.next;
                }

                // 问题退化成直接翻转链表
                if(next == null && k == len){
                    curr.next = prev;
                    return curr;
                }

                // 对应恰好能整数分组的状况
                if(next == null && cnt < k){
                    curr.next = prev;
                    curKHead = curr;
                    break;
                }

                // 上一组的表尾（翻转后的表尾是翻转前的表头，所以取名为preHead）指向当前组的curr
                if(preKHead != null){// 这里kHead为空的情况是第一组时
                    preKHead.next = prev;
                }

                // 当前组处理完毕，下一次循环就成了上一组，所以当前组的头变成了上一组的头(翻转后是尾)
                preKHead = curKHead;

                // 循环结束时，当前节点是下一组的起点，记住这个起点，方便让当前组指向下一组的curr
                curKHead = curr;

                // 如果是第一组，那么prev作为新链表的表头
                if(isFirst){
                    newHead = prev;
                    isFirst =false;
                }

                //----为下一组赋值------
                // 下一组作为独立的翻转链表，更新prev为null
                prev = null;

            }

            preKHead.next = curKHead;

            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);

        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;

//        int cnt = 0;
//        ListNode curr = ln1;
//        ListNode next = curr.next;
//        while (cnt < 3 && next != null){
//            cnt++;
//            System.out.println(cnt +"  "+curr.val);
//            curr = next;
//            next = next.next;
//        }
//        System.out.println(curr.val);
//
        LC0025 l = new LC0025();
        ListNode root = Solution.reverseKGroup(ln1, 4);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }

}
