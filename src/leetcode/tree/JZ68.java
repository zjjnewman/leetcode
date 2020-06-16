package leetcode.tree;

import java.util.*;

/**
 *
 * 原来想的是 preorder会产生 root A B，中序遍历 A root B，则A B 的最早公共祖先应该是先序遍历和A距离最近 切包含在中序遍历A B之前的节点
 * 集合，但A B 之间的公共集合也有非A B的公共祖先这点很显然
 *
 * 上面的推断推翻  因为 条件限定在 root A B   A root B同时满足这两个条件的数组必定是a b的祖先
 *
 *
 * 本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class JZ68 {

    //Definition for a binary leetcode.tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        //递归解法
        boolean isContainP = false;
        boolean isContainQ = false;
        TreeNode ancestor ;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root == null){
                return null;
            }
            if(p == null){
                return q;
            }
            if (q == null) {
                return p;
            }
            ancestor = root;
            solve(root, p, q);
            return ancestor;
        }

        public void solve(TreeNode root, TreeNode p, TreeNode q){
            isContainP = false;
            isContainQ = false;
            isAncestor(root, p, q);
            if(root != null){
                if(isContainQ && isContainP){
                    ancestor = root;
                }
                solve(root.left, p, q);
                solve(root.right, p, q);
            }
        }


        public void isAncestor(TreeNode root, TreeNode p, TreeNode q){
            if( root != null ){
                if(root == p){
                    isContainP = true;
                }
                if (root == q) {
                    isContainQ = true;
                }

                isAncestor(root.left, p, q);
                isAncestor(root.right, p, q);
            }
        }


        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            if(p == null){
                return q;
            }
            if (q == null) {
                return p;
            }

            List<TreeNode> preList = new ArrayList<>();
            List<TreeNode> inList = new ArrayList<>();

            preAndInOrderList(root, p, q, preList, inList);

            int lengthPre = preList.size();

            TreeNode t = null;
            for (int i = lengthPre - 1; i >= 0; i--){
                if(inList.contains(preList.get(i))){
                    t = preList.get(i);
                }
            }

            return t;
        }


        //遍历求出先序和中序a b 之前 之间的节点数组
        private void preAndInOrderList(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> preList, List<TreeNode> inList){
            LinkedList<TreeNode> stack = new LinkedList<>();

            boolean isPreAdd = true;
            boolean isInAdd = false;
            int inAddCnt = 0;


            while (root != null || stack.size() != 0){
                while (root != null){

                    if(isPreAdd){
                        preList.add(root);
                    }

                    if(root.val == p.val || root.val == q.val){
                        isPreAdd = false;
                    }

                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                if(root.val == p.val || root.val == q.val){
                    isInAdd = !isInAdd;
                    inAddCnt++;
                }

                if(isInAdd){
                    inList.add(root);
                }

                if(inAddCnt == 2){
                    inList.add(root);
                    inAddCnt = 0;
                }

                root = root.right;
            }
        }
    }

    /**
     *
     *作为LeetCode的前置学习知识，参考天勤《数据结构:高分笔记》，把树类的算法实现根据需要实现一遍
     *
     *           3
     *        /    \
     *       5      1
     *     /  \    /  \
     *    6   2   0   8
     *      /  \
     *     7   4
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;
        t3.left = t6;
        t5.left = t8;
        t5.right = t9;

        List<TreeNode> preList = new ArrayList<>();
        List<TreeNode> inList = new ArrayList<>();
        Solution s = new JZ68().new Solution();


//        TreeNode t= s.lowestCommonAncestor(t1, t2, t3);
        TreeNode t= s.lowestCommonAncestor(t1, t8, t9);

//        s.isAncestor(t5, t8, t9);
        System.out.println(t.val);


//        s.preOrder(t1, t2, t9, preList, inList);
//        for(TreeNode t0 : preList){
//            System.out.print(t0.val+"   ");
//        }
//        System.out.println();
//        for(TreeNode t0 : inList){
//            System.out.print(t0.val+"   ");
//        }
    }
}
