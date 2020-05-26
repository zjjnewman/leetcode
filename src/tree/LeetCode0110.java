package tree;

import linkedlist.LeetCode0328;

import java.util.Stack;

/**
 * 平衡二叉树
 * @author jin
 * 2020-05-25
 */
public class LeetCode0110 {

     //Definition for a binary tree node.

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            if(root.left == null && root.right == null){
                return true;
            }
            if(Math.abs(treeHight(root.left) - treeHight(root.right)) > 1){
                return false;
            } else {
                if(isBalanced(root.left)){
                  return isBalanced(root.right);
                } else {
                    return false;
                }
            }
        }

        //求树高
        public int treeHight(TreeNode root) {
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right != null){
                return 1 + treeHight(root.right);
            }
            if(root.left != null && root.right == null){
                return 1 + treeHight(root.left);
            }
            if(root.left != null && root.right != null) {
                return Math.max(1 + treeHight(root.left), 1 + treeHight(root.right));
            }
            return 1;
        }
        //求树高 官方改进版
        public int treeHight2(TreeNode root) {
            if(root == null){
                return -1;
            }
            return 1+Math.max(treeHight(root.left), treeHight2(root.right));
        }

        //官方改进版
        public boolean isBalanced2(TreeNode root) {
            if(root == null){
                return true;
            }

            if(Math.abs(treeHight(root.left) - treeHight(root.right)) > 1){
                return false;
            }

//            if(isBalanced(root.left)){
//                return isBalanced(root.right);
//            } else {
//                return false;
//            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

//    官方自底向上递归法
// Utility class to store information from recursive calls
    final class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    class Solution2 {
        // Return whether or not the tree at root is balanced while also storing
        // the tree's height in a reference variable.
        private TreeInfo isBalancedTreeHelper(TreeNode root) {
            // An empty tree is balanced and has height = -1
            if (root == null) {
                return new TreeInfo(-1, true);
            }

            // Check subtrees to see if they are balanced.
            TreeInfo left = isBalancedTreeHelper(root.left);
            if (!left.balanced) {
                return new TreeInfo(-1, false);
            }
            TreeInfo right = isBalancedTreeHelper(root.right);
            if (!right.balanced) {
                return new TreeInfo(-1, false);
            }

            // Use the height obtained from the recursive calls to
            // determine if the current node is also balanced.
            if (Math.abs(left.height - right.height) < 2) {
                return new TreeInfo(Math.max(left.height, right.height) + 1, true);
            }
            return new TreeInfo(-1, false);
        }

        public boolean isBalanced(TreeNode root) {
            return isBalancedTreeHelper(root).balanced;
        }
    };

//比较牛逼的自底向上解法
    class Solution3 {
        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) return 0;
            int left = recur(root.left);
            if(left == -1) return -1;
            int right = recur(root.right);
            if(right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
//        t1.left = t2;
//        t1.right = t6;
//        t2.left = t3;
//        t2.right = t4;
//        t3.left = t5;
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.left = t6;
        t5.right = t7;
        System.out.println(new Solution().treeHight2(t7));
        System.out.println(new Solution().isBalanced(t1));
    }

}
