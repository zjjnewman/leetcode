package leetcode.tree;

/**
 * @date 2020-06-07
 * 面试题54. 二叉搜索树的第k大节点
 *
 * 做此题的前置知识：
 */
public class JZ54 {

    //Definition for a binary leetcode.tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int kthLargest(TreeNode root, int k) {
            if(root != null){
                kthLargest(root.left, k-1);
                if(k == 1){
                    return root.val;
                }
                kthLargest(root.right, k-1);
            }
            return 0;
        }

        public int inOrder(TreeNode root, int k){
            if(root != null){
                inOrder(root.left, k-1);
                if(k == 1){
                    return root.val;
                }
                inOrder(root.right, k-1);
            }
            return 0;
        }


        int i = 1;
        int kVal = 0;
        public int kthLargest1(TreeNode root, int k) {
            if(root != null){
                kthLargest(root.right, k);

                if(i == k){
                    kVal = root.val;
                }
                i++;

                kthLargest(root.left, k);

            }
            return kVal;
        }
    }

}
