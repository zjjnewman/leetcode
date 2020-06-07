package datastructure.tree;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;
import datastructure.tree.TreeTraverse;
import tree.LeetCode0111;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


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

        //层次遍历
        treeTraverse.levelTraverse(t1);
//        System.out.println(treeTraverse.level);
    }
}