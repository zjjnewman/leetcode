package qiuzhao.yuewen;

public class T3 {


    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }


    static public TreeNode nearestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p || root==q){
            return root;
        }
        TreeNode l = nearestCommonAncestor(root.left, p, q);
        TreeNode r = nearestCommonAncestor(root.right, p, q);
        if(l==null)return r;
        if(r==null)return l;
        return root;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
