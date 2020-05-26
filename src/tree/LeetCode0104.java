package tree;

/**
 * 2020-05-25
 * 树高度 递归
 * @author jin
 */
public class LeetCode0104 {

    //Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
