package leetcode.linkedlist;

import datastructure.sorts.HeapSort;

import java.nio.file.NotDirectoryException;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Handler;

/**
 * 138. 复制带随机指针的链表 https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class LC138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    class Solution {
        public Node copyRandomList(Node head) {

//            if(head == null){
//                return null;
//            }
//
//            if(head.next == null){
//                Node node = new Node(head.val);
//                if(head.random == head){
//                    node.random = node;
//                }
//                return node;
//            }

            Node p = head;
            while (p != null){
                Node node = new Node(p.val);
                node.next = p.next;
                p.next = node;
                p = node.next;
            }

            p = head;
            while (p != null){
                if(p.random != null){
                    p.next.random = p.random.next;
                }
                p = p.next.next;
            }

            Node nHead = head.next;

            p = head;
            Node q = nHead;

            // 下面这段代码要特别注意，
            while (p.next != null){
                p.next = p.next.next;
                q.next = q.next.next;
                p = p.next;
                q = q.next;
            }
            p.next = null;


            return nHead;
        }


        // 解法1，arr法
        public Node copyRandomList1(Node head) {
            if(head == null){
                return null;
            }

            if(head.next == null){
                Node node = new Node(head.val);
                if(head.random == head){
                    node.random = node;
                }
                return node;
            }

            ArrayList<Node> srcArr = new ArrayList<>();

            Node p = head;
            while (p != null){
                srcArr.add(p);
                p = p.next;
            }

            ArrayList<Node> desArr = new ArrayList<>();



            for (int i = 0; i < srcArr.size(); i++) {
                desArr.add(new Node(srcArr.get(i).val));
                if(i - 1 >= 0){
                    desArr.get(i - 1).next = desArr.get(i);
                }
            }

            for (int i = 0; i < srcArr.size(); i++) {
                if(srcArr.get(i).random != null){
                    int idx = srcArr.indexOf(srcArr.get(i).random);
                    desArr.get(i).random = desArr.get(idx);
                }
            }
            return desArr.get(0);
        }
    }

    public static void main(String[] args) {

        Node h = new Node(-1);
        h.random = h;

        System.out.println(h.val);
        System.out.println(h);
        System.out.println(h.next);
        System.out.println(h.random);

        Node d = new LC138().new Solution().copyRandomList(h);

        System.out.println(d.val);
        System.out.println(d);
        System.out.println(d.next);
        System.out.println(d.random);


    }

}
