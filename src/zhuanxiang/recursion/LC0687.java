package zhuanxiang.recursion;

/**
 * 687. 最长同值路径 https://leetcode-cn.com/problems/longest-univalue-path/solution/zui-chang-tong-zhi-lu-jing-by-leetcode/
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点
 */
public class LC0687 {

    /**
     * 其实二叉树递归的难点就在于怎么构思：子节点向父节点返回的是什么?或者说，当前节点向其父节点返回的是什么?
     *
     * 这题中，当前节点返回给父节点的值就是： 从当前节点出发，向下延伸与其值相同的最大深度 于是返回值分两种情况：
     *      1. if( 如果当前节点与其左右节点都不相等)，那么深度为0，则返回0
     *      2. else 这个最大深度就取其 左右子树返回值中的较大者 + 1
     *
     * 然后，在上面这个dfs的遍历过程中，还可以做一些其他的事情，这题做的就是 计算路径长度。由于子树的返回值已经确定了，所以需要额外的一个全局变量。
     * 如何计算路径长度呢？其实知道了和自己数值相等的左右子树的最大高度了，那么 把左右子树返回的值相加 就是贯穿自己的最长路径了。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        static int path = 0;
        public static int longestUnivaluePath(TreeNode root) {
            if(root == null || (root.left == null && root.right == null)){
                return 0;
            }
            helper(root);
            return path;
        }

        public static int helper(TreeNode node){
            if(node == null){
                return 0;
            }
            int arrowLeft = 0;
            int arrowRight = 0;

            if(node.left != null && node.val == node.left.val){
                arrowLeft = arrowLeft + 1 + helper(node.left);
            }

            if(node.right != null && node.val == node.right.val){
                arrowRight= arrowRight + 1 + helper(node.right);
            }

            path = Math.max(path, arrowLeft + arrowRight);
            return Math.max(arrowLeft, arrowRight);

        }
    }
}
