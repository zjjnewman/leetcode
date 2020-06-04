package datastructure;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Tree {
    /**
     *
     *作为LeetCode的前置学习知识，参考天勤《数据结构:高分笔记》，把树类的算法实现根据需要实现一遍
     *
     *          10
     *        /   \
     *       5    -3
     *     /  \     \
     *    3   2     11
     *  /  \   \
     * 3   -2   1
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-2);
        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t3.left = null;
        t4.left = t7;
        t4.right =t8;
        t5.left = null;
        t5.right = t9;
        TreeTraverse treeTraverse = new TreeTraverse();

        //递归先序遍历
        treeTraverse.preOrderRecurse(t1);
        System.out.println();
        //迭代先序遍历
        treeTraverse.preOrderIterate(t1);
        System.out.println();

        //递归中序
        treeTraverse.inOrderRecurse(t1);
        System.out.println();
        //迭代中序
        treeTraverse.inOrderIterate(t1);
        System.out.println();

        //递归后序
        treeTraverse.postOrderRecurse(t1);
        System.out.println();
        //迭代后序
        treeTraverse.postOrderIterate(t1);
        System.out.println();
    }
}

/**
 * 二叉树的遍历
 * @date 2020-06-03
 */
class TreeTraverse{

    //先序遍历递归实现
    public void preOrderRecurse(TreeNode root){
        if(root != null){
            System.out.print(root.val+"   ");
            preOrderRecurse(root.left);
            preOrderRecurse(root.right);
        }
    }
    //先序遍历迭代实现
    public void preOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack<>();
//        while (!stack.isEmpty()){
//            System.out.print(root.val+"   ");
//            stack.push(root);
//            root = root.left;
//            if(root == null){
//                root = stack.pop();
//                if(root.right != null){
//                    root = root.right;
//                }
//            }
//        }
        while (!stack.isEmpty() || root != null){
            while (root != null){
                System.out.print(root.val+"   ");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }


    //中序遍历递归
    public void inOrderRecurse(TreeNode root){
        if (root != null) {
            inOrderRecurse(root.left);
            System.out.print(root.val+"   ");
            inOrderRecurse(root.right);
        }
    }
    //中序遍历迭代
    public void inOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+"   ");
            root = root.right;
        }
    }


    //后序遍历递归
    public void postOrderRecurse(TreeNode root){
        if(root != null){
            postOrderRecurse(root.left);
            postOrderRecurse(root.right);
            System.out.print(root.val+"   ");
        }
    }
    /**
     * 后序遍历迭代
     * 有点难看的答案
     *
     * 恍然大悟：后序遍历的顺序是：左右根。先序遍历的顺序是：根左右，如果入栈后弹出变为 右左根。若先序变为 根右左 再入栈弹出 就是 左右根
     * @param root
     */
    public void postOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack();
        IStack<TreeNode> output = new IStack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                output.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().val+ "   ");
        }
    }
}

