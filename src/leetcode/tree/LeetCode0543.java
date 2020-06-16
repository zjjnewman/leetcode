package leetcode.tree;

import java.util.Stack;

public class LeetCode0543 {
    /**
     * 2025-05-25
     * 二叉树的直径
     * @author jin
     */

     //Definition for a binary leetcode.tree node.

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            int dia1 = Math.max(treeHight(root.left) + treeHight(root.right), diameterOfBinaryTree(root.left));
            int dia2 = diameterOfBinaryTree(root.right);
            return dia1 > dia2 ? dia1 : dia2;
//            int dia1 = 0;
//            int dia2;
//            return (dia1 = Math.max(treeHight(root.left) + treeHight(root.right), diameterOfBinaryTree(root.left))) >
//                    (dia2 = diameterOfBinaryTree(root.right)) ? dia1 : dia2;
        }

        public int diameterOfBinaryTree2(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();
            TreeNode t = root;
            int hl = 0;
            int hr = 0;
            int h = 0;
            while (true){
                if(t != null){
                    hr++;
                    t = stack.push(t).left;
                } else {
                    t = stack.pop().right;
                    hl = 0;
                    hr = 0;
                    h = hl + hr;
                }
            }
        }


        int max = 0;
        public int diameterOfBinaryTree3(TreeNode root) {
            depth(root);
            return max;
        }

        public int depth(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            int dp = Math.max(left, right)+1;
            max = Math.max(left + right, max);
            return dp;
        }

        public int treeHight(TreeNode root){
            if(root == null){
                return 0;
            }
            return 1 + Math.max(treeHight(root.left), treeHight(root.right));
        }
    }


    //官方题解，用时为0ms 比我15ms快了很多
    class Solution2 {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
            if (node == null) return 0; // 访问到空节点了，返回0
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }

    public static void main(String[] args) {
        LeetCode0543.TreeNode t1 = new LeetCode0543.TreeNode(1);
        LeetCode0543.TreeNode t2 = new LeetCode0543.TreeNode(2);
        LeetCode0543.TreeNode t3 = new LeetCode0543.TreeNode(3);
        LeetCode0543.TreeNode t4 = new LeetCode0543.TreeNode(4);
        LeetCode0543.TreeNode t5 = new LeetCode0543.TreeNode(5);
        LeetCode0543.TreeNode t6 = new LeetCode0543.TreeNode(6);
        LeetCode0543.TreeNode t7 = new LeetCode0543.TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t3.left = t7;
        System.out.println(new Solution().diameterOfBinaryTree(t1));
    }
}
