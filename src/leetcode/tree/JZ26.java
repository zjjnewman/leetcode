package leetcode.tree;

/**
 * @date 2020-06-13
 * 面试题26. 树的子结构 https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 貌似和LeetCode0572很像，让人想到kmp
 */
public class JZ26 {

    //Definition for a binary leetcode.tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        //递归
        boolean isBFirst = true;
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(B == null && isBFirst){
                isBFirst = false;
                return false;
            }
            if(B == null && A == null){
                return true;
            }

            if(A == null){
                return false;
            }

            if(B == null){
                return true;
            }

            return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean helper(TreeNode node, TreeNode B){
            if(B == null && node == null){
                return true;
            }

            if(node == null){
                return false;
            }

            if(B == null){
                return true;
            }

            if(node.val != B.val){
                return false;
            }

            return helper(node.left, B.left) && helper(node.right, B.right);
        }

        //以上递归改进
        public boolean isSubStructure1(TreeNode A, TreeNode B) {
            if(A == null || B == null){
                return false;
            }

            return helper1(A, B) || isSubStructure(A.right, B) ||isSubStructure(A.left, B);
        }
        public boolean helper1(TreeNode A, TreeNode B){
            if(B == null){
                return true;
            } else if(A == null){
                return false;
            }
            if(A.val != B.val){
                return false;
            }
            return helper1(A.left, B.left) && helper1(A.right, B.right);
        }
    }
}
