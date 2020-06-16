package leetcode.tree;

import datastructure.tree.TreeNode;
import datastructure.tree.TreeTraverse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 这里没有补充递归的解法
 * @date 2020-06-13
 * 这个题在我上午的时候想过怎么把数组变为一颗树，代码过程见JZ34，说来也很巧啊，看来没事儿多思考好处很多啊。
 *
 * 面试题37. 序列化二叉树 本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 */
public class JZ37 {

    //Definition for a binary leetcode.tree node.
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }

    public class Codec {

        // Encodes a leetcode.tree to a single string.
        public String serialize(TreeNode root) {

            if(root == null){
                return "[]";
            }
            if(root.left == null && root.right == null){
                return new StringBuilder("[").append(root.val).append("]").toString();
            }

            List<Integer> serializedArr = new ArrayList<>();

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            serializedArr.add(root.val);
            TreeNode node;

            while (!queue.isEmpty()){
                node = queue.remove();


                if(node.left != null){
                    queue.add(node.left);
                    serializedArr.add(node.left.val);
                } else {
                    serializedArr.add(null);
                }

                if(node.right != null){
                    queue.add(node.right);
                    serializedArr.add(node.right.val);
                } else {
                    serializedArr.add(null);
                }
            }
            //移除最后null；
            while (serializedArr.get(serializedArr.size()-1) == null){
                serializedArr.remove(serializedArr.size()-1);
            }
            return serializedArr.toString();
        }


        // Decodes your encoded data to leetcode.tree.
        /**
         *     1
         *    / \
         *   2   3
         *      / \
         *     4   5
         *
         * 序列化为 "[1,2,3,null,null,4,5]"
         */
        public TreeNode deserialize(String data) {
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
            data = data.replace(" ", "");
            String[] valArr = data.split(",");

            if(valArr.length == 2){
                TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
                root.left = new TreeNode(Integer.parseInt(valArr[1]));
                return root;
            }

            TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            TreeNode node;
            int i = 1;
            while (!queue.isEmpty() && i < valArr.length){
                node = queue.remove();

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



        //优化一下
        public String serialize1(TreeNode root) {

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


        public TreeNode deserialize1(String data) {
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



        //递归
        TreeNode head;
        public String serialize2(TreeNode root) {
            if(root == null){
                return "[]";
            }
            StringBuilder stringBuilder = new StringBuilder("[").append(root.val);
            proTraverse(root, stringBuilder);
            return stringBuilder.append("]").toString();
        }

        public void proTraverse(TreeNode root, StringBuilder stringBuilder){
            if(root != null){
                if (root.left == null){
                    if(root.right != null){
                        stringBuilder.append("null").append(",");

                        stringBuilder.append(root.right.val).append(",");
                    }
                } else {
                    stringBuilder.append(root.left.val).append(",");
                    if(root.right != null){
                        stringBuilder.append(root.right.val);
                    } else {

                    }
                }

                proTraverse(root.left, stringBuilder);
                proTraverse(root.right, stringBuilder);
            }
        }

        // Decodes your encoded data to leetcode.tree.
        public TreeNode deserialize2(String data) {
            return head;
        }


    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

    public static void main(String[] args) {
        TreeTraverse treeTraverse = new TreeTraverse();
        Codec codec = new JZ37().new Codec();
        TreeNode treeNode = codec.deserialize1("[3,2,null,4,1]");

        String s = codec.serialize1(treeNode);
        System.out.println(s);


//        treeTraverse.inOrderRecurse(treeNode);
//        System.out.println();
//        treeTraverse.preOrderRecurse(treeNode);
//        System.out.println();
//        treeTraverse.postOrderRecurse(treeNode);
    }
}
