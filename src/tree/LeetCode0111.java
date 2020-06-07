package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的最小深度（路径的节点数）
 * 这个貌似和之前的某个递归很像，递归的做法没想起来。
 * @date 2020-06-06
 */

public class LeetCode0111 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        int level = 0;
        //每层的节点数
        int levelCntUp = 0;
        int levelCntDown = 0;

        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
//            LinkedList<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> queue = new Queue<>();
            queue.add(root);

            levelCntUp++;
            level++;
            TreeNode node;

            while (queue.peek() != null){
                node = queue.remove();
                levelCntUp--;

                if(node.left != null){
                    queue.add(node.left);
                    levelCntDown++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    levelCntDown++;
                }

                if(node.right == null && node.left == null){
                    return level;
                }

                if(levelCntUp == 0){
                    level++;
                    levelCntUp = levelCntDown;
                    levelCntDown = 0;
                }
            }
            return level;
        }


        class Queue<T> {
            class Node<T>{
                T t;
                Node<T> next;
                public Node(T t){
                    this.t = t;
                }
            }

            Node<T> head;
            Node<T> tail;

            public boolean add(T t){
                if(t == null){
                    return false;
                }
                Node<T> node = new Node<>(t);
                if(head == null){
                    head = node;
                }
                tail.next = node;
                tail = node;

                return true;
            }

            public T remove(){
                Node<T> node = head;
                head = head.next;
                node.next = null;
                return node.t;
            }

            public T peek(){
                return head.t;
            }
        }


        /**
         * 递归解法，不太会，
         * 不是简单地边界条件，还要考虑剪枝递归，如：若一个节点两边有一个不为空，这个节点就不能返回，要返回左右都为空的。
         * @param root
         * @return
         */
        public int minDepth1(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.right == null && root.left == null){
                return 1;
            }

            if(root.left != null && root.right == null){
                return 1 + minDepth1(root.left);
            }

            if(root.right != null && root.left == null){
                return 1 + minDepth1(root.right);
            }

            return 1 + Math.min(minDepth1(root.left), minDepth1(root.right));
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> levelLists = new ArrayList<>();

    }
}



