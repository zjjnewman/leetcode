package tree;

/**
 * 自己不会，参考答案
 * 2020-05-27
 * 112. 路径总和
 * @author jin
 */
public class LeetCode0112 {

    //Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    自己不会，看的答案

    class Solution {
        int SUM = 0;
        int initSum = 0;
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }
            sum = sum - root.val;
            if(root.left == null && root.right == null){
                return sum == 0;
            }
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}

class Solution{

}
