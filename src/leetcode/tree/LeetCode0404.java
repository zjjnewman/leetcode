package leetcode.tree;

public class LeetCode0404 {


    //Definition for a binary leetcode.tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    class Solution {
        int sumOfLeft = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }

            //这里只有一个根节点，按0计算
            if(root.right == null && root.left == null){
//                return root.val;
                return 0;
            }

            return sumOfLeftLeaves(root, false);
        }

        public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
            if(root == null){
                return 0;
            }

            if(root.left == null && root.right == null && isLeft){
                return sumOfLeft + root.val;
            }

            if(root.left == null){
                return sumOfLeft + sumOfLeftLeaves(root.right, false);
            }

            if(root.right == null){
                return sumOfLeft + sumOfLeftLeaves(root.left, true);
            }

            //不然就返回两子树都不空的状况
            return sumOfLeft + sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }
}
