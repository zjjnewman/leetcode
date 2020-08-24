package leetcode.tree;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

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


    @PostConstruct
    private void init(){
        System.out.println("构造器之后，属性赋值完成，调用初始化");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("移除之后调用");
    }




    public int[] kmpNext(String partternStr){

        /**
         * 说明：
         *
         * next     [0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
         *  i        a   b   a   a   b   b   a   b   a   a   b
         *  j    a   b   a   a   b   b   a   b   a   a   b
         *
         * i是上边串的下标 也是next数组的下标， j 是 下边的串的下标
         */
        int[] next = new int[partternStr.length()];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while(i < partternStr.length() - 1)
        {
            if(j == -1 || partternStr.charAt(i) == partternStr.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];//此语句是这段代码最反人类的地方，如果你一下子就能看懂，那么请允许我称呼你一声大神！
            }
        }
        return next;
    }

    public int[] kmpNext1(String partternStr){



        return null;
    }



    public static void main(String[] args) {
        LeetCode0572 t = new LeetCode0572();
        System.out.println(Arrays.toString(t.kmpNext("ababc")));
    }
}
