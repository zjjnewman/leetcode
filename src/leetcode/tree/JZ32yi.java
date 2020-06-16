package leetcode.tree;


import java.util.*;

/**
 * @date 2020-06-10
 * 面试题32 - I. 从上到下打印二叉树
 */
public class JZ32yi {

    //Definition for a binary leetcode.tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

//        public int[] levelOrder1(TreeNode root) {
//
//        }


        public int[] levelOrder(TreeNode root) {
            if(root == null){
                return new int[0];
            }

            ArrayList<Integer> arrayList = levelTraverse(root);
            int[] arr = new int[arrayList.size()];
            int i = 0;

            for (int integer : arrayList) {
                arr[i] = integer;
                i++;
            }
            return arr;
        }

        public ArrayList<Integer> levelTraverse(TreeNode root){
            if(root == null){
                return null;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> arrayList = new ArrayList<>();

            TreeNode node = null;
            int upCnt = 0;
            int downCnt = 0;

            queue.add(root);
            upCnt++;

            while (!queue.isEmpty()){
               node = queue.remove();
               arrayList.add(node.val);
               upCnt--;
               if(node.left != null){
                   queue.add(node.left);
                   downCnt++;
               }
               if(node.right != null){
                   queue.add(node.right);
                   downCnt++;
               }

               if(upCnt == 0){
                   upCnt = downCnt;
                   downCnt = 0;
               }
            }
            return (ArrayList<Integer>) arrayList;
        }
    }

    public static void main(String[] args) {

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
        ArrayList<Integer> l = new JZ32yi().new Solution().levelTraverse(t1);
        for(int i : l){
            System.out.print(i + "   ");
        }

    }
}
