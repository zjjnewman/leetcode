package test;

import leetcode.tree.JZ07;
import qiuzhao.haikangweishi.T;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1 {
    int post = 0;
    static public class TreeNode {
        long val;
        TreeNode left;
        TreeNode right;
        TreeNode(long x) { val = x; }
    }
    long[] po;
    HashMap<Long, Integer> dic = new HashMap<>();
    public long[] buildPostOrder (long[] preorder, long[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        TreeNode root = helper(0,0, inorder.length-1);
        long[] ret = new long[preorder.length];
        postOrderRecurse(root, ret);
        return ret;
    }
    public TreeNode helper(int preroot, int inlow, int inhigh) {
        if(inlow>inhigh)return null;
        TreeNode root = new TreeNode(po[preroot]);
        int i = dic.get(po[preroot]);
        root.left = helper(preroot+1, inlow, i-1);
        root.left = helper(preroot+i-inlow+1,i+1, inhigh);
        return root;
    }

    public void postOrderRecurse(TreeNode root, long[] ret){
        if(root != null){
            postOrderRecurse(root.left, ret);
            postOrderRecurse(root.right, ret);
            System.out.println(root.val);
//            ret[post++] = root.val;
        }
    }

    public static void main(String[] args) {
        T1 t = new T1();
        System.out.println(Arrays.toString(t.buildPostOrder(new long[]{1, 2, 3}, new long[]{2, 1, 3})));
    }
}
