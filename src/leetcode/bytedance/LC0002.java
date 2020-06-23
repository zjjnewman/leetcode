package leetcode.bytedance;

/**
 * 2. 两数相加 https://leetcode-cn.com/problems/add-two-numbers/  445. 两数相加2 https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class LC0002 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            ListNode p = l1;
            ListNode q = l2;

            // 存储进位值
            int carry = 0;

            // p q 两指针都为空时 记录其前一个节点
            ListNode pre = null;

            //当二者都不为空，就执行加法
            while (p != null && q != null){
                int sum = p.val + q.val + carry;

                // 看二者相加是否有进位
                carry = sum / 10;

                // 不管是否有进位，其余数必为此位最终值
                // 写入两个链表的目的是哪个先空就返回另外一个
                p.val = sum % 10;
                q.val = sum % 10;
                pre = p;
                p = p.next;
                q = q.next;
            }

            if(p == null && q == null) {
                if (carry != 0) {
                    pre.next = new ListNode(carry);
                }
                return l1;
            }

            if(p == null){
               l1 = l2;
               p = q;
            }

            if(carry == 0){
                return l1;
            }

            while (p != null ){
                int sum = p.val + carry;
                carry = sum / 10;
                p.val = sum % 10;
                if(carry == 0){
                    break;
                }
                pre = p;
                p = p.next;
            }

            if(carry != 0){
                pre.next = new ListNode(carry);
            }
            return l1;

            // 注意还要考虑最后一位进位的问题

        }

    }

    public static void main(String[] args) {

    }
}
