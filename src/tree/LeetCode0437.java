package tree;

/** *************************************没想通
 * 2020-05-27
 * 437. 路径总和 III
 * @author jin
 */
public class LeetCode0437 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int SUM = 0;
        int c = 0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null){
                return 0;
            }
            return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }
            sum = sum - root.val;
            if(sum == 0){
                return true;
            } else {
                return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
            }
        }

        public int helper(TreeNode root, int sum){
            if(root == null) {
                return 0;
            }
            sum -= root.val;
            return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
        }


    }

    public void dfs(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        LeetCode0437.TreeNode t1 = new LeetCode0437.TreeNode(10);
        LeetCode0437.TreeNode t2 = new LeetCode0437.TreeNode(5);
        LeetCode0437.TreeNode t3 = new LeetCode0437.TreeNode(-3);
        LeetCode0437.TreeNode t4 = new LeetCode0437.TreeNode(3);
        LeetCode0437.TreeNode t5 = new LeetCode0437.TreeNode(2);
        LeetCode0437.TreeNode t6 = new LeetCode0437.TreeNode(11);
        LeetCode0437.TreeNode t7 = new LeetCode0437.TreeNode(3);
        LeetCode0437.TreeNode t8 = new LeetCode0437.TreeNode(-2);
        LeetCode0437.TreeNode t9 = new LeetCode0437.TreeNode(1);
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
//        System.out.println(new LeetCode0437().new Solution().pathSum(t1, 8));
//        new LeetCode0437().dfs(t1);
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
