package leetcode.tree;

/**
 * 自己不会，理解答案，需要理解kmp
 * @date
 */
public class LeetCode0572 {

    //Definition for a binary leetcode.tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null){
                return false;
            }

            if(isSametree(s, t)){
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t) ;
            }
        }

        public boolean isSametree(TreeNode s, TreeNode t){
            if(s == null && t == null){
                return true;
            }

            if(s == null || t == null){
                return false;
            }
            if(s.val != t.val){
                return false;
            }
            return isSametree(s.left, t.left) && isSametree(s.right, t.right);
        }
    }


    public int[] kmpNext1(String partternStr){
        int[] next = new int[partternStr.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while(j < partternStr.length() - 1)
        {
            if(k == -1 || partternStr.charAt(k) == partternStr.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];//此语句是这段代码最反人类的地方，如果你一下子就能看懂，那么请允许我称呼你一声大神！
            }
        }
        return next;
    }



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-2);
        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t3.left = null;
        t4.left = t7;
        t4.right =t8;
        t5.left = null;
//        t5.right = t9;
        System.out.println(new LeetCode0572().new Solution().isSubtree(t1, t9));
    }
}
