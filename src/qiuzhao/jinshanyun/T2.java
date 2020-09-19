package qiuzhao.jinshanyun;

import java.util.*;

public class T2 {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        if(data.length() == 1){
            return new TreeNode(Integer.parseInt(data));
        }
        //若串长不为1，树有多个节点，准备数据结构，然后迭代构造树
        data = data.trim();
        String[] valArr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        TreeNode node;
        int i = 1;
        int idx = 0;

        while (idx < queue.size() && i < valArr.length){
            node = queue.get(idx);
            idx++;
            if(!valArr[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.left);
            }

            i++;
            if(i == valArr.length){
                break;
            }

            if(!valArr[i].equals("-1")){
                node.right = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 到底了还没找到，返回 null
        if (root == null) {
            return null;
        }
        // 如果找到了 p 或 q，返回它
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // left 记录 p 或 q 是在左子树找到的
        TreeNode right = lowestCommonAncestor(root.right, p, q); // right 记录 p 或 q 是在右子树找到的
        // 如果连个都记录了找到的节点，那么肯定是一个记录了 p ，另一个记录了 q
        // 它们分别在以 root 为根的左右子树中，所以 root 就是它们的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 由于节点 p,q 一定在二叉树宏，left和right不会同时为null
        // 若 left != null && right == null，说明在左子树中找到了p或q，而在右子树找不到p或q，则剩下一个也在左子树
        // 所以left就是最近公共祖先
        // 另一种情况同理
        return (left != null) ? left : right;
    }

    private static boolean isFind(TreeNode root, TreeNode tar){
        if(root == null){
            return false;
        }
        if(root.val == tar.val){
            return true;
        }
        return isFind(root.left, tar) || isFind(root.right, tar);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int aVal = sc.nextInt();
        int bVal = sc.nextInt();
        TreeNode root = deserialize(s);

        TreeNode aNode = new TreeNode(aVal);
        TreeNode bNode = new TreeNode(bVal);

        TreeNode treeNode = lowestCommonAncestor(root, aNode, bNode);
        System.out.println(treeNode.val);
    }
}
