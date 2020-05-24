package linkedlist;

import java.util.ArrayList;

public class LeetCode0725 {

    //Definition for singly-linked list.

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode p = root;

            //求出链表总长度，即总结点数
            int len = 0;
            while (p != null){
                len++;
                p = p.next;
            }

            //求解较多节点的分链表数目
            int highNodeNum = len % k;
            //求解较少节点的分链表数量
            int lowNodeNum = k - highNodeNum;

            ListNode[] nodeArr = new ListNode[k];
            p = root;
            int index = 0;

            //用于存储上一个分链表的最后节点使其指向null
            ListNode q;

            int tmp;
            //先处理较多节点分链表，下面是计数变量
            if((tmp = highNodeNum) == 0){
                tmp = lowNodeNum;
            }
            //判断是否转化成对较少节点分链表的处理
            boolean isTransfer = false;
            while (tmp > 0 && p != null){
                tmp--;
                nodeArr[index] = p;
                index++;
                //每部分链表基 数目
                int partNodeNum = 0;
                if(!isTransfer && highNodeNum != 0){
                    partNodeNum = len / k;
                    if(tmp == 0){
                        isTransfer = true;
                        tmp = lowNodeNum;
                    }
                } else {
                    partNodeNum = len / k - 1;
                }
                while (partNodeNum > 0){
                    partNodeNum--;
                    p = p.next;
                }
                q = p;
                p = p.next;
                q.next = null;
            }

            return nodeArr;
        }
    }
}
