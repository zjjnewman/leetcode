package datastructure.tree;

import org.junit.jupiter.api.DynamicTest;

import java.util.*;

/**
 * 树的序列化，反序列化
 */
public class TreeUtils {
    /**
     *
     *作为LeetCode的前置学习知识，参考天勤《数据结构:高分笔记》，把树类的算法实现根据需要实现一遍
     *
     *          10
     *        /   \
     *       5    -3
     *     /  \     \
     *    3   2     11
     *  /  \   \
     * 3   -2   1
     */

    //树序列化
    public static String serialize(TreeNode root) {

        if(root == null){
            return "[]";
        }
        if(root.left == null && root.right == null){
            return new StringBuilder("[").append(root.val).append("]").toString();
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>(){
            @Override
            public String toString() {
                Iterator<TreeNode> it = this.iterator();
                if(!it.hasNext()){
                    return "[]";
                }

                StringBuilder sb = new StringBuilder();
                sb.append("[");

                for(;;){
                    TreeNode e = it.next();
                    sb.append((e == null ? "null" : e.val));
                    if(!it.hasNext()){
                        return sb.append("]").toString();
                    }
                    sb.append(",");
                }
            }
        };

        queue.add(root);
        TreeNode node;

        int i = 0;
        while (i < queue.size()){
            node = queue.get(i);
            i++;
            if(node == null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        //移除最后null；
        while (queue.get(queue.size()-1) == null){
            queue.remove(queue.size()-1);
        }
        return queue.toString();
    }

    //树反序列化
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }

        //去除"[]"
        data = data.substring(1, data.length()-1);

        //去除"[]"后的字符串长若为1，则只有一个根节点直接返回
        if(data.length() == 1){
            return new TreeNode(Integer.parseInt(data));
        }

        //若串长不为1，树有多个节点，准备数据结构，然后迭代构造树
        //去除字符串中的空格
        data = data.replace(" ", "");
        String[] valArr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        TreeNode node;
        int i = 1;
        int idx = 0;

        while (idx < queue.size() && i < valArr.length){
            node = queue.get(idx);
            idx++;

            if(!valArr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.left);
            }

            i++;
            if(i == valArr.length){
                break;
            }

            if(!valArr[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.right);
            }

            i++;

        }

        return root;
    }


    public int[] kmpNext(String str){
        int i = 0;
        int j = -1;
        int[] next = new int[str.length()];
        next[0] = -1;

        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static boolean isSameTree(TreeNode r1, TreeNode r2){

        if(r1 == null && r2 != null){
            return false;
        }
        if(r2 == null && r1 != null){
            return false;
        }

        if(r1 == null && r2 == null){
            return true;
        }

        if(r1.val != r2.val){
            return false;
        }

        return isSameTree(r1.left, r2.left) ||
        isSameTree(r1.right, r2.right);
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
        t5.right = t9;

        System.out.println(TreeUtils.serialize(t1));
        TreeNode root = TreeUtils.deserialize(TreeUtils.serialize(t1));
        System.out.println(isSameTree(t1, root));

//        TreeTraverse treeTraverse = new TreeTraverse();
//        //递归先序遍历
//        treeTraverse.preOrderRecurse(t1);
//        System.out.println();
//        //迭代先序遍历
//        treeTraverse.preOrderIterate(t1);
//        System.out.println();
//
//        //递归中序
//        treeTraverse.inOrderRecurse(t1);
//        System.out.println();
//        //迭代中序
//        treeTraverse.inOrderIterate(t1);
//        System.out.println();
//
//        //递归后序
//        treeTraverse.postOrderRecurse(t1);
//        System.out.println();
//        //迭代后序
//        treeTraverse.postOrderIterate(t1);
//        System.out.println();
//
//        //层次遍历
//        treeTraverse.levelTraverse(t1);
//        System.out.println(treeTraverse.level);


    }
}