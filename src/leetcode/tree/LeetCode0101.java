package leetcode.tree;

import java.util.LinkedList;

public class LeetCode0101 {

    //Definition for a binary leetcode.tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        //Linklist迭代解法
        public boolean isSymmetric3(TreeNode root) {
            if(root == null){
                return true;
            }
            LinkedList<TreeNode> stack1 = new LinkedList<>();
            LinkedList<TreeNode> stack2 = new LinkedList<>();
            TreeNode l = root.left;
            TreeNode r = root.right;
            while (l != null || stack1.peekFirst() != null || r != null || stack2.peekFirst() != null){
                while (l != null || r != null){
                    try {
                        stack1.push(l);
                        stack2.push(r);

                        if(l.val != r.val){
                            return false;
                        }
                    } catch (Exception e){
                        return false;
                    }
                    l = l.left;
                    r = r.right;
                }

                try{
                    l = stack1.pop();
                    l = l.right;

                    r = stack2.pop();
                    r = r.left;
                } catch (Exception e){
                    return false;
                }
            }

            return true;
        }


        //栈迭代解法
        public boolean isSymmetric2(TreeNode root) {
            if(root == null){
                return true;
            }
            IStack<TreeNode> stack1 = new IStack<>();
            IStack<TreeNode> stack2 = new IStack<>();
            TreeNode l = root.left;
            TreeNode r = root.right;
            while (l != null || !stack1.isEmpty() || r != null || !stack2.isEmpty()){
                while (l != null || r != null){
                    try {
                        stack1.push(l);
                        stack2.push(r);
                    } catch (RuntimeException e){
                        return false;
                    }
                    if(l.val != r.val){
                        return false;
                    }
                    l = l.left;
                    r = r.right;
                }
                try{
                    l = stack1.pop();
                    l = l.right;
                    r = stack2.pop();
                } catch (RuntimeException e){
                    return false;
                }
                r = r.left;
            }
            return true;
        }

        /**
         * 迭代错误版本，没考虑左右树数值相同的状况
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            IStack<TreeNode> stack1;
            IStack<TreeNode> stack2;
            stack1 = traverseTree(root.left, false);
            stack2 = traverseTree(root.right, true);
            while (stack1.top != null && stack2.top != null){
                if(stack1.pop().val != stack2.pop().val){
                    return false;
                }
            }
            return stack1.top == null && stack2.top == null;
        }

        public IStack<TreeNode> traverseTree(TreeNode root, boolean isReverseTra){
            IStack<TreeNode> stack = new IStack<>();
            IStack<TreeNode> storeStack = new IStack<>();
            while (root != null || !stack.isEmpty()){
                while (root != null){
                    storeStack.push(root);
                    if(isReverseTra){
                        root = root.right;
                    } else {
                        root = root.left;
                    }
                }
                root = stack.pop();
                stack.push(root);
                if(isReverseTra){
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return storeStack;
        }

        /**
         * 定制版栈，可以入栈空树节点，
         * @param <T>
         */

        class IStack<T>{

            class Node<T>{
                Node<T> top;
                Node<T> next;
                T t;
                private Node(T t){
                    this.t = t;
                }
            }

            Node<T> top;
            public T pop(){
                if(top == null){
                    throw new RuntimeException("stack is Empty");
                }
                Node<T> ele = top;
                top = top.next;
                ele.next = null;
                return ele.t;
            }

            public T push(T t){
                if(t == null){
                    throw new RuntimeException("element can't be null");
                }
                Node<T> ele = new Node<>(t);
                ele.next = top;
                top = ele;
                return t;
            }

            public boolean isEmpty(){
                return top == null;
            }
        }
    }




    //递归
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode s, TreeNode t){
            if(s == null && t == null){
                return true;
            }
            if(s == null || t != null){
                return false;
            }
            if(s.val != t.val){
                return false;
            }
            return isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        }
    }

    public static void main(String[] args) {

    }
}



