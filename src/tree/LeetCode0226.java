package tree;

/**
 * 2020-05-26
 * 翻转二叉树
 * @author jin
 */
public class LeetCode0226 {

    //Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            if(root.left == null && root.right == null){
                return root;
            }
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
