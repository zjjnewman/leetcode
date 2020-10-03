package Tmp;

public class T1 {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除单链表倒数第n个节点，打印最终结果。比如：a->k->e->n->l->z倒数第三个n被删除。
     */
    static public ListNode delN(ListNode head, int n){
        if(head==null){
            return null;
        }
        ListNode pHelper = head;
        ListNode pPrev = head;
        int tmp = n;
        while (tmp != 0 && pHelper.next != null){
            pHelper = pHelper.next;
            tmp--;
        }

        if(tmp != 0)return head;

        while (pHelper.next != null){
            pPrev = pPrev.next;
            pHelper = pHelper.next;
        }
        pPrev.next = pPrev.next.next;

        return head;

    }

    /*
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode h = delN(head, 3);
        while (h!=null){
            System.out.println(h.val);
            h=h.next;
        }
    }
}
